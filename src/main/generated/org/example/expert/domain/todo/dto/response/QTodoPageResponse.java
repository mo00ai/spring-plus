package org.example.expert.domain.todo.dto.response;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * org.example.expert.domain.todo.dto.response.QTodoPageResponse is a Querydsl Projection type for TodoPageResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QTodoPageResponse extends ConstructorExpression<TodoPageResponse> {

    private static final long serialVersionUID = 122774784L;

    public QTodoPageResponse(com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<Long> managersCount, com.querydsl.core.types.Expression<Long> commentCount) {
        super(TodoPageResponse.class, new Class<?>[]{String.class, long.class, long.class}, title, managersCount, commentCount);
    }

}

