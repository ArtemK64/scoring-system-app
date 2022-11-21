package ru.scoring_system.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsValidator implements ConstraintValidator<IsValid, String> {
    @Override
    public boolean isValid(String inputAnswer, ConstraintValidatorContext constraintValidatorContext) {
        return inputAnswer.equalsIgnoreCase("A") || inputAnswer.equalsIgnoreCase("B") || inputAnswer.equalsIgnoreCase("C");
    }
}
