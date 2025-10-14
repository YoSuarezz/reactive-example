package co.edu.uco.reactiveexample.service.impl;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.publisher.CountryPublisher;
import co.edu.uco.reactiveexample.repository.CountryRepository;
import co.edu.uco.reactiveexample.service.CountryService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;
    private final CountryPublisher publisher;

    public CountryServiceImpl(final CountryRepository repository,final CountryPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    @Override
    public Mono<CountryEntity> create(CountryEntity country) {
        return repository.save(country).then(repository.findByName(country.getName())).doOnNext(publisher::sendCreatedEvent);
    }

    @Override
    public Mono<CountryEntity> update(int id, CountryEntity country) {
        return repository.findById(id)
                .flatMap(existing -> {
                    existing.setName(country.getName());
                    existing.setCountry_code(country.getCountry_code());
                    existing.setIso_country_code(country.getIso_country_code());
                    existing.setEnabled(country.isEnabled());
                    return repository.save(existing);
                });
    }

    @Override
    public Mono<CountryEntity> delete(int id) {
        return repository.findById(id)
                .flatMap(existing ->
                        repository.delete(existing)
                                .then(Mono.just(existing))
                );
    }

    @Override
    public Mono<CountryEntity> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Mono<CountryEntity> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Flux<CountryEntity> findAll() {
        return repository.findAll();
    }
}
