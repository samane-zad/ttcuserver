package ac.ttcu.common.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotBlankValidator implements ConstraintValidator<NotBlank, String> {

    public void initialize(NotBlank parameters) {
        // Nothing to do here
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext constraintValidatorContext) {
        if (value.replace(" ", "").length() < 0 || value == null || value == "")
            return false;
        else return true;
    }
}
