package de.tngbl.ewm.domain.basisdaten;

/**
 * Dieses Value Object beschreibt den Ortsnamen.
 */
public record Ort(String value) {

    public Ort {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Ortsname darf nicht leer sein.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
