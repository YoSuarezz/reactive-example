package co.edu.uco.reactiveexample.publisher;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import co.edu.uco.reactiveexample.publisher.event.CountryEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Component
public class CountryPublisher {

    private final Sinks.Many<CountryEvent> sink = Sinks.many().multicast().onBackpressureBuffer();

    public void sendCreatedEvent(final CountryEntity countryEntity) {
        sink.tryEmitNext(new CountryEvent(countryEntity, CountryEvent.EventType.CREATE));
    }

    public void sendUpdatedEvent(final CountryEntity countryEntity) {
        sink.tryEmitNext(new CountryEvent(countryEntity, CountryEvent.EventType.UPDATE));
    }

    public void sendDeletedEvent(final CountryEntity countryEntity) {
        sink.tryEmitNext(new CountryEvent(countryEntity, CountryEvent.EventType.DELETE));
    }

    public Flux<CountryEvent> getStream() {
        return sink.asFlux();
    }

}
