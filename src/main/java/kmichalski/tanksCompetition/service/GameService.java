package kmichalski.tanksCompetition.service;

import kmichalski.tanksCompetition.model.Game;
import kmichalski.tanksCompetition.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public Game createNewGame(Game game) {
        return gameRepository.save(game);
    }
}
