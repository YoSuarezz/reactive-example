package co.edu.uco.reactiveexample.publisher.event;

import co.edu.uco.reactiveexample.entity.CountryEntity;
import jdk.jfr.EventType;

public class CountryEvent {

    private CountryEntity entity;
    private EventType eventType;

    public enum EventType {
        CREATE,
        UPDATE,
        DELETE
    }

    public CountryEvent(final CountryEntity entity,final EventType eventType) {
        super();
        setEntity(entity);
        setEventType(eventType);
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public CountryEntity getEntity() {
        return entity;
    }

    public void setEntity(CountryEntity entity) {
        this.entity = entity;
    }
}
