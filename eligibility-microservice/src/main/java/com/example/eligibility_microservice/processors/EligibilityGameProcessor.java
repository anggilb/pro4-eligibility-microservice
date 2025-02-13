package com.example.eligibility_microservice.processors;

import com.example.eligibility_microservice.commons.GameCreatedEvent;
import com.example.eligibility_microservice.commons.GameEligibleEvent;
import com.example.eligibility_microservice.services.GameEligibleService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class EligibilityGameProcessor {
    private static final Logger log = LoggerFactory.getLogger(EligibilityGameProcessor.class);

    private GameEligibleService gameEligibleService;

    public EligibilityGameProcessor(GameEligibleService gameEligibleService) {
        this.gameEligibleService = gameEligibleService;
    }

    public Flux<GameEligibleEvent> process(Flux<GameCreatedEvent> gameCreatedEventFlux) {
        return gameCreatedEventFlux.doOnNext(given -> log.info("Entry event: {}", given))
                .flatMap(gameEligibleService::eligibilityGame)
                .onErrorContinue(this::handleError);
    }

    private void handleError(Throwable throwable, Object object) {
        log.error("Error processing event: {}", object, throwable);
    }
}
