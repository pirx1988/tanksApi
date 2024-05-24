package kmichalski.tanksCompetition.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kmichalski.tanksCompetition.model.GameStatus;

public class GameStatusValidator implements ConstraintValidator<ValidGameStatus, String> {

    @Override
    public boolean isValid(String validatedGameStatus, ConstraintValidatorContext context) {
        if (validatedGameStatus == null) {
            return true; // Use @NotNull on the field to check for null
        }
        for (GameStatus status : GameStatus.values()) {
            if (status.toString().equals(validatedGameStatus)) {
                return true;
            }
        }
        return false;
    }
}
