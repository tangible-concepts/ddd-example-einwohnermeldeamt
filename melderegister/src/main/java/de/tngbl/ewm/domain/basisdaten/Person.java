package de.tngbl.ewm.domain.basisdaten;

/**
 * Dieses Value Object beschreibt eine Person.
 * Alle Bestandteile müssen vorhanden sein.
 */
public record Person(Vorname vorname, Nachname nachname, Adresse adresse, Geburtsdatum geburtsdatum, Personalausweisnummer personalausweisnummer) {

    public Person {
        if (vorname == null || nachname == null || adresse == null || geburtsdatum == null || personalausweisnummer == null) {
            throw new IllegalArgumentException("Person muss vollständig sein.");
        }
    }

    @Override
    public String toString() {
        return vorname + " " + nachname + ", " + geburtsdatum + ", " + personalausweisnummer + ", " + adresse;
    }

}
