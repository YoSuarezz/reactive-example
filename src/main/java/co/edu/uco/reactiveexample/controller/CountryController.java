package co.edu.uco.reactiveexample.controller;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.publisher.CountryPublisher;
import co.edu.uco.reactiveexample.publisher.event.CountryEvent;
import co.edu.uco.reactiveexample.service.CountryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;

@RestController
@RequestMapping("api/v1/countries")
public class CountryController {

    private CountryService service;
    private CountryPublisher publisher;

    public CountryController(final CountryService service, final CountryPublisher publisher) {
        this.service = service;
        this.publisher = publisher;
    }

    @GetMapping("dummy")
    public Mono<CountryEntity> getDummyCountry(){
        CountryEntity country = new CountryEntity();
        return Mono.just(country);
    }

    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<CountryEvent> publishEvents() {
        return publisher.getStream();
    }

    @GetMapping
    public Flux<CountryEntity> getAllCountries(){
        return service.findAll();
    }

    @PostMapping
    public Mono<CountryEntity> saveCountry(@RequestBody CountryEntity countryEntity){
        return service.create(countryEntity);
    }

    @PutMapping("{id}")
    public Mono<CountryEntity> updateCountry(@PathVariable("id") int id,
                                             @RequestBody CountryEntity countryEntity){
        return service.update(id, countryEntity);
    }

    @DeleteMapping("{id}")
    public Mono<CountryEntity> deleteCountry(@PathVariable("id") int id) {
        return service.delete(id);
    }
}
