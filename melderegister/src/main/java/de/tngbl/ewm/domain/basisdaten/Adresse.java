package de.tngbl.ewm.domain.basisdaten;

/**
 * Dieses Value Object beschreibt die Adresse einer Person.
 * Alle Bestandteile müssen vorhanden sein
 */
public record Adresse(Strasse strasse, Hausnummer hausnummer, Postleitzahl plz, Ort ort) {

    public Adresse {
        if (strasse == null || hausnummer == null || plz == null || ort == null) {
            throw new IllegalArgumentException("Adresse muss vollständig sein.");
        }
    }

    @Override
    public String toString() {
        return strasse + " " + hausnummer + ", " + plz + " " + ort;
    }

}
