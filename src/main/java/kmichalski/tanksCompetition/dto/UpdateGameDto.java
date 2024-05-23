package kmichalski.tanksCompetition.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kmichalski.tanksCompetition.model.GameStatus;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UpdateGameDto {
    @NotNull(message = "Game status must not be null")
    GameStatus gameStatus;
    @Min(value = 0, message = "First player Game score must be bigger or equal than zero")
    int firstPlayerScore;
    @Min(value = 0, message = "Second player Game score must be bigger or equal than zero")
    int SecondPlayerScore;
}
