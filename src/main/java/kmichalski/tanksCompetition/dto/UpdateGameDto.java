package kmichalski.tanksCompetition.dto;

import kmichalski.tanksCompetition.model.GameStatus;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UpdateGameDto {
    GameStatus gameStatus;
    int firstPlayerScore;
    int SecondPlayerScore;
}
