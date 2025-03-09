package de.tngbl.ewm.domain.basisdaten;

/**
 * Dieses Value Object beschreibt den Nachnamen einer Person.
 * Nachnamen können aus einem Wort oder mehreren bestehen. Die Wörter können mit leerzeichen oder Bindestrichej nsepariert sein. Ziffern sind nicht erlaubt.
 */
public record Nachname(String value) {

    public Nachname {
        if (value == null || !value.matches("[A-Za-zäöüÄÖÜß]+[\\w\\s-]*")) {
            throw new IllegalArgumentException("Nachname muss mit einem Buchstaben beginnen und kann danach beliebig viele Wörter und Bindestriche enthalten.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
