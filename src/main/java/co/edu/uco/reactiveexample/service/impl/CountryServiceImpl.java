package co.edu.uco.reactiveexample.service.impl;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.repository.CountryRepository;
import co.edu.uco.reactiveexample.service.CountryService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;


    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<CountryEntity> create(CountryEntity country) {
        return null;
    }

    @Override
    public Mono<CountryEntity> update(int id, CountryEntity country) {
        return null;
    }

    @Override
    public Mono<CountryEntity> delete(int id) {
        return null;
    }

    @Override
    public Mono<CountryEntity> findById(int id) {
        return null;
    }

    @Override
    public Mono<CountryEntity> findByName(String name) {
        return null;
    }

    @Override
    public Flux<CountryEntity> findAll() {
        return repository.findAll();
    }
}
