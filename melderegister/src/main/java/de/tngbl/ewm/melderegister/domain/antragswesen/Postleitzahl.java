package de.tngbl.ewm.melderegister.domain.antragswesen;

/**
 * Dieses Value Object beschreibt die Postleitzahl.
 * Valide Postlietzahlen bestehen aus 5 Ziffern, die erste Stelle darf nicht '0' sein.
 */
public record Postleitzahl(String value) {

    public Postleitzahl {
        if (value == null || !value.matches("[1-9]\\d{4}")) {
            throw new IllegalArgumentException("Postleitzahl muss 5-stellig sein.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
