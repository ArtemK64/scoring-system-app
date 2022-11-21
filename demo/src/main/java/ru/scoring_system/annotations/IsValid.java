package ru.scoring_system.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target( { FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IsValidator.class)
public @interface IsValid {
    String message() default "The answer can be A or B or C";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}