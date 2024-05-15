package com.gabrielgua.filmes.api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { DataLancamentoValidator.class })
public @interface DataLancamento {
    String message() default "deve ser uma data válida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
