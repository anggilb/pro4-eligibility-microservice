package com.example.games_service_api.controller;

import com.example.games_service_api.commons.constants.ApiPathConstants;
import com.example.games_service_api.commons.dtos.GameResponse;
import com.example.games_service_api.commons.dtos.GameRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.GAME_ROUTE)
public interface GameApi {
    @PostMapping(value = "/create")
    ResponseEntity<?> createGame(
            @RequestHeader("X-User-Id") Long userId,
            @RequestBody @Valid GameRequest gameRequest,
            BindingResult result
    );

    @GetMapping(value = "/{gameId}")
    ResponseEntity<?> getGame(
            @RequestHeader("X-User-Id") Long userId,
            @PathVariable Long gameId
    );

    @PutMapping(value = "/{gameId}")
    ResponseEntity<?> putGame(
            @RequestHeader("X-User-Id") Long userId,
            @PathVariable Long gameId,
            @RequestBody @Valid GameRequest gameRequest
    );

    @DeleteMapping(value = "/{gameId}")
    ResponseEntity<?> deleteGame(
            @RequestHeader("X-User-Id") Long userId,
            @PathVariable Long gameId
    );
}
