package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

    @Test
    void namesFlux() {
        var namesFLux = fluxAndMonoGeneratorService.namesFlux();

        StepVerifier.create(namesFLux)
                //.expectNext("alex", "ben", "chloe")
                .expectNext("alex")
                .expectNextCount(2)
                .verifyComplete();
    }

}