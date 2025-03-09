package de.tngbl.ewm.domain.basisdaten;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Dieses Value Object beschreibt das Geburtsdatum einer Person.
 */
public record Geburtsdatum (LocalDate value) {

    public static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /**
     * Das Geburtsdatum darf nicht in der Zukunft liegen.
     */
    public Geburtsdatum {

        if (value.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Geburtsdatum darf nicht in der Zukunft liegen.");
        }

    }

    @Override
    public String toString() {
        return value.format(DATE_FORMAT);
    }

}
