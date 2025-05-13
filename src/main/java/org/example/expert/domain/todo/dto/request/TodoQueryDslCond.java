package org.example.expert.domain.todo.dto.request;

import java.time.LocalDate;

import org.example.expert.domain.common.validator.DateRange;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@DateRange
public class TodoQueryDslCond {

	private String title;
	private String nickname;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;

}
