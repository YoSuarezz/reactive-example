package co.edu.uco.reactiveexample.service;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CountryService {

    Mono<CountryEntity> create(CountryEntity country);

    Mono<CountryEntity> update(int id, CountryEntity country);

    Mono<CountryEntity> delete(int id);

    Mono<CountryEntity> findById(int id);

    Mono<CountryEntity> findByName(String name);

    Flux<CountryEntity> findAll();
}
