package kmichalski.tanksCompetition.controller;

import jakarta.validation.Valid;
import kmichalski.tanksCompetition.dto.UpdateGameDto;
import kmichalski.tanksCompetition.model.Game;
import kmichalski.tanksCompetition.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @GetMapping("/games")
    public ResponseEntity<List<Game>> fetchGames() {
        return ResponseEntity.ok().body(gameService.findGames());
    }

    // Start game
    @PutMapping("/update-game/{gameId}")
    public ResponseEntity<Game> updateGame(@Valid @RequestBody UpdateGameDto updateGameDto, @PathVariable UUID gameId) {
        return ResponseEntity.ok().body(gameService.updateGame(gameId, updateGameDto));
    }
}
