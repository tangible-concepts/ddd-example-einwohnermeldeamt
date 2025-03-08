package de.tngbl.ewm.melderegister.domain;

/**
 * Dieses Value Object beschreibt den Vornamen einer Person.
 * Vornamen dürfen nicht leer sein, müssen mindestens einen Buchstaben enthalten und dürfen keine Sonderzeichen enthalten. Ziffern sind nicht erlaubt.
 */
public record Vorname(String value) {

    public Vorname {
        if (value == null || !value.matches("[A-Za-zäöüÄÖÜß]+")) {
            throw new IllegalArgumentException("Vorname muss mindestens einen Buchstaben enthalten und darf keine Sonderzeichen enthalten.");
        }
    }

    @Override
    public String toString() {
        return value;
    }

}
