package org.example.expert.domain.todo.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.example.expert.domain.comment.entity.QComment;
import org.example.expert.domain.manager.entity.QManager;
import org.example.expert.domain.todo.dto.response.QTodoPageResponse;
import org.example.expert.domain.todo.dto.response.TodoPageResponse;
import org.example.expert.domain.todo.entity.QTodo;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TodoRepositoryImpl implements TodoRepositoryCustom{

	private final JPAQueryFactory queryFactory;
	QTodo todo = QTodo.todo;
	QManager manager = QManager.manager;
	QComment comment = QComment.comment;

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

		List<TodoPageResponse> todoList = queryFactory
			.select(new QTodoPageResponse(
				todo.title,
				JPAExpressions.select(manager.count())
					.from(manager)
					.where(manager.todo.id.eq(todo.id)),
				JPAExpressions.select(comment.count())
					.from(comment)
					.where(comment.todo.id.eq(todo.id))
			))
			.from(todo)
			.where(
				titleLike(title),
				nicknameLike(nickname),
				dateBetween(startDate, endDate)
			)
			.orderBy(todo.createdAt.desc())
			.offset(pageable.getOffset())
			.limit(pageable.getPageSize())
			.fetch();

		Long total = queryFactory
			.select(todo.count())
			.from(todo)
			.where(
				titleLike(title),
				nicknameLike(nickname),
				dateBetween(startDate, endDate)
			)
			.fetchOne();

		if (total == null) {
			total = 0L;
		}

		return new PageImpl<>(todoList,pageable,total);
	}

	//검색 where조건
	private BooleanExpression titleLike(String title) {
		return title != null ? todo.title.like("%"+title+"%") : null;
	}

	private BooleanExpression nicknameLike(String nickname) {
		return nickname != null ? todo.user.nickname.like("%"+nickname+"%") : null;
	}

	private BooleanExpression dateBetween(LocalDateTime startDate, LocalDateTime endDate) {

		return (startDate != null && endDate != null) ? todo.createdAt.between(startDate, endDate) : null;

	}

}
