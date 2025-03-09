package de.tngbl.ewm.domain.basisdaten;

/**
 * Dieses Value Object beschreibt die Personalausweisnummer einer Person.
 */
public record Personalausweisnummer(String value) {

    public Personalausweisnummer {
        if (value == null || !value.matches("\\d{10}")) {
            throw new IllegalArgumentException("Personalausweisnummer muss 10-stellig sein.");
        }
    }

    @Override
    public String toString() {
        return value;
    }

}
