package org.example.expert.domain.todo.dto.response;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class TodoPageResponse {

	private final String title;
	private final Long managersCount;
	private final Long commentCount;

	@QueryProjection
	public TodoPageResponse(String title, Long managersCount, Long commentCount) {
		this.title = title;
		this.managersCount = managersCount;
		this.commentCount = commentCount;
	}
}
