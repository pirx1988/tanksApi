package kmichalski.tanksCompetition.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import kmichalski.tanksCompetition.model.GameStatus;
import kmichalski.tanksCompetition.validation.ValidGameStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateGameDto {
    @ValidGameStatus(targetClassType = GameStatus.class)
    @NotNull(message = "Game status must not be null")
    String gameStatus;
    @Min(value = 0, message = "First player Game score must be bigger or equal than zero")
    int firstPlayerScore;
    @Min(value = 0, message = "Second player Game score must be bigger or equal than zero")
    int SecondPlayerScore;
}
