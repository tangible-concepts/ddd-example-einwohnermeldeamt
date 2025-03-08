package de.tngbl.ewm.melderegister.domain;

import java.util.UUID;

/**
 * Value Object für die Antragsnummer eines Antrags.
 * Antragsnummern sind eindeutig und werden automatisch generiert. Sie bestehen aus einer UUID.
 */
public record Antragsnummer(UUID value) {

    public Antragsnummer {
        if (value == null) {
            throw new IllegalArgumentException("Antragsnummer darf nicht null sein.");
        }
    }

    public static Antragsnummer neu() {
        return new Antragsnummer(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
