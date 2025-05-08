package org.example.expert.domain.todo.repository;

import java.util.Optional;

import org.example.expert.domain.todo.entity.QTodo;
import org.example.expert.domain.todo.entity.Todo;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TodoRepositoryImpl implements TodoRepositoryCustom{

	private final JPAQueryFactory queryFactory;

	@Override
	public Optional<Todo> findByIdWithUserQueryDsl(long todoId) {

		QTodo todo = QTodo.todo;

		Todo foundTodo = queryFactory
			.select(todo)
			.from(todo)
			.leftJoin(todo.user)
			.fetchJoin()
			.where(todo.id.eq(todoId))
			.fetchOne();

		return Optional.ofNullable(foundTodo);
	}
}
