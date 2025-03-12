package de.tngbl.ewm.domain.eventbus;

import java.time.LocalDateTime;

public abstract class DomainEvent {

    private final LocalDateTime erzeugt = LocalDateTime.now();

    public LocalDateTime getErzeugt() {
        return erzeugt;
    }

}
