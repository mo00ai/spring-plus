package org.example.expert.domain.todo.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.example.expert.domain.todo.dto.response.TodoPageResponse;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TodoRepositoryCustom {
	Optional<Todo> findByIdWithUserQueryDsl(long todoId);

	Page<TodoPageResponse> findAllBySearch(String title, String nickname, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
}
