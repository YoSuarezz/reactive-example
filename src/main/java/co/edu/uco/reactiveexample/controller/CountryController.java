package co.edu.uco.reactiveexample.controller;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.service.CountryService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/countries")
public class CountryController {

    private CountryService service;

    public CountryController(final CountryService service) {
        super();
        this.service = service;
    }

    @GetMapping
    public Flux<CountryEntity> getAllCountries(){
        return service.findAll();
    }

    @PostMapping
    public Mono<CountryEntity> saveCountry(@RequestBody CountryEntity countryEntity){
        return service.create(countryEntity);
    }

    @PutMapping
    public Mono<CountryEntity> updateCountry(@RequestBody CountryEntity countryEntity){
        return service.create(countryEntity);
    }

    @DeleteMapping("{id}")
    public Mono<CountryEntity> deleteCountry(@PathVariable("id") int id) {
        return service.delete(id);
    }
}
