package de.tngbl.ewm.domain.melderegister;

import java.util.UUID;

/**
 * Value Object für die Nummer eines Registereintrags.
 */
public record RegistereintragNummer(UUID value) {

    public RegistereintragNummer {
        if (value == null) {
            throw new IllegalArgumentException("RegistereintragNummer darf nicht null sein.");
        }
    }

    public static RegistereintragNummer neu() {
        return new RegistereintragNummer(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
