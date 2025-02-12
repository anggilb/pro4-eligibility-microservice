package com.example.games_service_api.controller.impl;

import com.example.games_service_api.commons.dtos.GameRequest;
import com.example.games_service_api.commons.dtos.GameResponse;
import com.example.games_service_api.controller.GameApi;
import com.example.games_service_api.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController implements GameApi {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public ResponseEntity<GameResponse> createGame(Long userId, GameRequest gameRequest) {
        return ResponseEntity.ok(gameService.createGame(userId, gameRequest));
    }

    @Override
    public ResponseEntity<GameResponse> getGame(Long userId, Long gameId) {
        return ResponseEntity.ok(gameService.getGame(userId, gameId));
    }

    @Override
    public ResponseEntity<Void> putGame(Long userId, Long gameId, GameRequest gameRequest) {
        gameService.putGame(userId, gameId, gameRequest);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteGame(Long userId, Long gameId) {
        gameService.deleteGame(userId, gameId);
        return ResponseEntity.noContent().build();
    }
}
