package de.tngbl.ewm.domain.basisdaten;

/**
 * Dieses Value Object beschreibt die Hausnummer eines Gebäudes.
 * Hausnummern beginnen mit Ziffern, die erste Stelle darf nicht null sein. Danach dürfen Buchstaben folgen, z.B. 12, 23a, 6b
 */
public record Hausnummer(String value) {

    public Hausnummer {
        if (value == null || !value.matches("\\d+[a-zA-Z]*")) {
            throw new IllegalArgumentException("Hausnummer muss mit einer Ziffer beginnen und kann danach Buchstaben enthalten.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
