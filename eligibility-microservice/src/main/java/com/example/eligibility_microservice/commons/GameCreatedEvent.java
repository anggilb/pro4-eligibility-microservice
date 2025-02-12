package com.example.eligibility_microservice.commons;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameCreatedEvent {
    private Integer gameId;
    private String nameGame;
    private Integer userId;
}
