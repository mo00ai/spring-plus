package org.example.expert.domain.todo.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.example.expert.domain.todo.dto.response.TodoPageResponse;
import org.example.expert.domain.todo.entity.QTodo;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TodoRepositoryImpl implements TodoRepositoryCustom{

	private final JPAQueryFactory queryFactory;
	QTodo todo = QTodo.todo;

	@Override
	public Optional<Todo> findByIdWithUserQueryDsl(long todoId) {

		Todo foundTodo = queryFactory
			.select(todo)
			.from(todo)
			.leftJoin(todo.user)
			.fetchJoin()
			.where(todo.id.eq(todoId))
			.fetchOne();

		return Optional.ofNullable(foundTodo);
	}

	@Override
	public Page<TodoPageResponse> findAllBySearch(String title, String nickname, LocalDateTime startDate, LocalDateTime endDate,
		Pageable pageable) {

		return null;
	}

	//검색 where조건
	private BooleanExpression titleLike(String title) {
		return title != null ? todo.title.like("%"+title+"%") : null;
	}

	private BooleanExpression nicknameLike(String nickname) {
		return nickname != null ? todo.user.nickname.like("%"+nickname+"%") : null;
	}

}
