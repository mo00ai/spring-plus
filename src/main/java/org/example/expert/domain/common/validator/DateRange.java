package org.example.expert.domain.common.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateRangeValidator.class)
public @interface DateRange {

	String message() default "날짜 검색 시, 시작일과 종료일은 모두 입력해야 합니다.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
