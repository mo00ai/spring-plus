package org.example.expert.domain.common.validator;

import org.example.expert.domain.todo.dto.request.TodoQueryDslCond;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<DateRange, TodoQueryDslCond> {

	@Override
	public boolean isValid(TodoQueryDslCond cond, ConstraintValidatorContext constraintValidatorContext) {

		if(cond.getStartDate() == null && cond.getEndDate() == null) {
			return true;
		}

		if(cond.getStartDate() != null && cond.getEndDate() != null) {
			return true;
		}

		return false;

	}
}
