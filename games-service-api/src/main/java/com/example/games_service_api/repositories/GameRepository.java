package com.example.games_service_api.repositories;

import com.example.games_service_api.commons.entities.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<GameModel, Long> {
    @Query("SELECT g FROM GameModel g WHERE g.userId = :userId AND g.gameId = :gameId")
    Optional<GameModel> findByUserIdAndGameId(@Param("userId") Long userId, @Param("gameId") Long gameId);
}
