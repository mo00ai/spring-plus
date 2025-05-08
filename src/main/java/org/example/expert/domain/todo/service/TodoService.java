package org.example.expert.domain.todo.service;

import java.time.LocalDateTime;

import lombok.RequiredArgsConstructor;
import org.example.expert.client.WeatherClient;
import org.example.expert.domain.common.exception.InvalidRequestException;
import org.example.expert.domain.todo.dto.request.TodoQueryDslCond;
import org.example.expert.domain.todo.dto.request.TodoSaveRequest;
import org.example.expert.domain.todo.dto.request.TodoSearchCond;
import org.example.expert.domain.todo.dto.response.TodoResponse;
import org.example.expert.domain.todo.dto.response.TodoSaveResponse;
import org.example.expert.domain.todo.entity.Todo;
import org.example.expert.domain.todo.repository.TodoRepository;
import org.example.expert.domain.user.dto.response.UserResponse;
import org.example.expert.domain.user.entity.User;
import org.example.expert.domain.user.repository.UserRepository;
import org.example.expert.security.CustomUserPrincipal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final UserRepository userRepository;
    private final TodoRepository todoRepository;
    private final WeatherClient weatherClient;

    @Transactional
    public TodoSaveResponse saveTodo(CustomUserPrincipal userPrincipal, TodoSaveRequest todoSaveRequest) {

        User user = userRepository.findById(userPrincipal.getUser().getId())
            .orElseThrow(() -> new InvalidRequestException("User not found"));

        String weather = weatherClient.getTodayWeather();

        Todo newTodo = new Todo(
                todoSaveRequest.getTitle(),
                todoSaveRequest.getContents(),
                weather,
                user
        );
        Todo savedTodo = todoRepository.save(newTodo);

        return new TodoSaveResponse(
                savedTodo.getId(),
                savedTodo.getTitle(),
                savedTodo.getContents(),
                weather,
                new UserResponse(user.getId(), user.getEmail())
        );
    }

    @Transactional(readOnly = true)
    public Page<TodoResponse> getTodos(TodoSearchCond cond, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        LocalDateTime startDate = (cond.getStartDate() != null) ?  cond.getStartDate().atStartOfDay() : null;
        LocalDateTime endDate = (cond.getEndDate() != null) ? cond.getEndDate().atTime(23,59,59):null;
        String weather = cond.getWeather();


        Page<Todo> todos = todoRepository.findAllByOrderByModifiedAtDesc(weather,startDate,endDate,pageable);

        return todos.map(todo -> new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getContents(),
                todo.getWeather(),
                new UserResponse(todo.getUser().getId(), todo.getUser().getEmail()),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        ));
    }



    @Transactional(readOnly = true)
    public TodoResponse getTodo(long todoId) {
        Todo todo = todoRepository.findByIdWithUserQueryDsl(todoId)
                .orElseThrow(() -> new InvalidRequestException("Todo not found"));

        User user = todo.getUser();

        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getContents(),
                todo.getWeather(),
                new UserResponse(user.getId(), user.getEmail()),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        );
    }

    public Page<TodoResponse> getTodosByQueryDsl(TodoQueryDslCond cond, int page, int size) {

        Pageable pageable = PageRequest.of(page - 1, size);

        LocalDateTime startDate = (cond.getStartDate() != null) ?  cond.getStartDate().atStartOfDay() : null;
        LocalDateTime endDate = (cond.getEndDate() != null) ? cond.getEndDate().atTime(23,59,59):null;

        todoRepository.findAllBySearch(cond.getTitle(), cond.getNickname(), startDate, endDate, pageable);

        return null;
    }
}
