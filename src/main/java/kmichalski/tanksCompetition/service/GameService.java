package kmichalski.tanksCompetition.service;

import kmichalski.tanksCompetition.dto.UpdateGameDto;
import kmichalski.tanksCompetition.model.Game;
import kmichalski.tanksCompetition.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;

    public Game createNewGame(Game game) {
        return gameRepository.save(game);
    }

    public List<Game> findGames() {
        return gameRepository.findAll();
    }

    public Game updateGame(UUID gameId, UpdateGameDto updateGameDto) {
        Game toUpdateGame = gameRepository.findByGameId(gameId).orElseThrow();
        toUpdateGame.setGameStatus(updateGameDto.getGameStatus());
        toUpdateGame.setFirstPlayerScore(updateGameDto.getFirstPlayerScore());
        toUpdateGame.setSecondPlayerScore(updateGameDto.getSecondPlayerScore());
        gameRepository.save(toUpdateGame);
        return toUpdateGame;
    }
}
