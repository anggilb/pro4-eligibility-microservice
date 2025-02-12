package com.example.games_service_api.commons.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameRequest {
    @NotNull
    private String name;
}
