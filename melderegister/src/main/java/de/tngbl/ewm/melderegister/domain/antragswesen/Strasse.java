package de.tngbl.ewm.melderegister.domain.antragswesen;

/**
 * Dieses Value Object beschreibt den Straßennamen.
 * Straßennamen beginnen mit einem Buchstaben und dürfen dann aus bleibig vielen Wörtern bestehen und auch Ziffern beinhalten, zb. "Hauptstraße", "Am Bahnhof", "L14"
 */
public record Strasse(String value) {

    public Strasse {
        if (value == null || !value.matches("[A-Za-zßäöüÄÖÜ]+[\\w\\s]*")) {
            throw new IllegalArgumentException("Straßenname muss mit einem Buchstaben beginnen und kann danach beliebig viele Wörter und Ziffern enthalten.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
