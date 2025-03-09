package de.tngbl.ewm.domain.melderegister;

import de.tngbl.ewm.domain.basisdaten.Hausnummer;
import de.tngbl.ewm.domain.basisdaten.Ort;
import de.tngbl.ewm.domain.basisdaten.Postleitzahl;
import de.tngbl.ewm.domain.basisdaten.Strasse;

import java.util.UUID;

/**
 * Dieses Entity beschreibt eine Meldeadresse.
 */
public class Meldeadresse {

    private UUID id;
    private final Strasse strasse;
    private final Hausnummer hausnummer;
    private final Postleitzahl plz;
    private final Ort ort;

    public Meldeadresse(Strasse strasse, Hausnummer hausnummer, Postleitzahl plz, Ort ort) {
        this.id = UUID.randomUUID();
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Strasse getStrasse() {
        return strasse;
    }

    public Hausnummer getHausnummer() {
        return hausnummer;
    }

    public Postleitzahl getPlz() {
        return plz;
    }

    public Ort getOrt() {
        return ort;
    }
}

