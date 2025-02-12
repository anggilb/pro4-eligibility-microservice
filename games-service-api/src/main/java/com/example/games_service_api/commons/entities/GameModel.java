package com.example.games_service_api.commons.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "games")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameId;
    private String name;
    private Long userId;
}
