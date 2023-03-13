package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.List;

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

    @Test
    void namesFluxMap() {
        var namesFlux = fluxAndMonoGeneratorService.namesFluxMap();

        StepVerifier.create(namesFlux)
                .expectNext("ALEX", "BEN", "CHLOE")
                .verifyComplete();
    }

    @Test
    void namesFluxImmutability() {
        var namesFlux = fluxAndMonoGeneratorService.namesFluxImmutability();

        StepVerifier.create(namesFlux)
                .expectNext("alex", "ben", "chloe")
                .verifyComplete();
    }

    @Test
    void testNamesFluxMap() {
        var namesFlux = fluxAndMonoGeneratorService.namesFluxMap(3);

        StepVerifier.create(namesFlux)
                .expectNext("4-ALEX", "5-CHLOE")
                .verifyComplete();
    }

    @Test
    void namesFluxFlatMap() {
        var namesFlux = fluxAndMonoGeneratorService.namesFluxFlatMap(3);

        StepVerifier.create(namesFlux)
                .expectNext("A", "L", "E", "X", "C", "H", "L", "O", "E")
                .verifyComplete();
    }

    @Test
    void namesFluxFlatMapAsync() {
        var namesFlux = fluxAndMonoGeneratorService.namesFluxFlatMapAsync(3);

        StepVerifier.create(namesFlux)
                //.expectNext("A","L","E","X","C","H","L","O","E")
                .expectNextCount(9)
                .verifyComplete();
    }

    @Test
    void namesFluxConcatMap() {
        var namesFlux = fluxAndMonoGeneratorService.namesFluxConcatMap(3);

        StepVerifier.create(namesFlux)
                .expectNext("A", "L", "E", "X", "C", "H", "L", "O", "E")
                //.expectNextCount(9)
                .verifyComplete();
    }

    @Test
    void namesMonoFlatMap() {
        var value = fluxAndMonoGeneratorService.namesMonoFlatMap(3);

        StepVerifier.create(value)
                .expectNext(List.of("A", "L", "E", "X"))
                .verifyComplete();
    }

    @Test
    void namesMonoFlatMapMany() {
        var value = fluxAndMonoGeneratorService.namesMonoFlatMapMany(3);

        StepVerifier.create(value)
                .expectNext("A", "L", "E", "X")
                .verifyComplete();
    }

}