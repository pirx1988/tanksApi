package kmichalski.tanksCompetition.controller;

import kmichalski.tanksCompetition.model.Game;
import kmichalski.tanksCompetition.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;
    @PostMapping("/create-new-game")
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        Game createdGame = gameService.createNewGame(game);

        // Build the URI for the newly created resource
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdGame.getId())
                .toUri();
        // Return ResponseEntity with 201 Created status code and location header
        return ResponseEntity.created(location).body(createdGame);
    }
}
