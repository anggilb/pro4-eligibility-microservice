package com.example.games_service_api.controller;

import com.example.games_service_api.commons.constants.ApiPathConstants;
import com.example.games_service_api.commons.dtos.GameResponse;
import com.example.games_service_api.commons.dtos.GameRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.GAME_ROUTE)
public interface GameApi {
    @PostMapping(value = "/create")
    ResponseEntity<GameResponse> createGame(
            @RequestHeader("X-User-Id") Long userId,
            @RequestBody GameRequest gameRequest
    );

    @GetMapping(value = "/{gameId}")
    ResponseEntity<GameResponse> getGame(
            @RequestHeader("X-User-Id") Long userId,
            @PathVariable Long gameId
    );

    @PutMapping(value = "/{gameId}")
    ResponseEntity<Void> putGame(
            @RequestHeader("X-User-Id") Long userId,
            @PathVariable Long gameId,
            @RequestBody GameRequest gameRequest
    );

    @DeleteMapping(value = "/{gameId}")
    ResponseEntity<Void> deleteGame(
            @RequestHeader("X-User-Id") Long userId,
            @PathVariable Long gameId
    );
}
