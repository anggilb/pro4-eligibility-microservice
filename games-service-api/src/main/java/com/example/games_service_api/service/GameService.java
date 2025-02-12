package com.example.games_service_api.service;

import com.example.games_service_api.commons.dtos.GameRequest;
import com.example.games_service_api.commons.dtos.GameResponse;

public interface GameService {
    GameResponse createGame(Long userId, GameRequest gameRequest);
    GameResponse getGame(Long userId, Long gameId);
    void putGame(Long userId, Long gameId, GameRequest gameRequest);
    void deleteGame(Long userId, Long gameId);
}
