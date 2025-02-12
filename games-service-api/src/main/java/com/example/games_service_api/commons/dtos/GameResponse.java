package com.example.games_service_api.commons.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameResponse {
    @NotNull
    private Long gameId;
    @NotNull
    private String name;
}
