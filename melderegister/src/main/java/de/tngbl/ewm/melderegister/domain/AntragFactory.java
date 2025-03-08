package de.tngbl.ewm.melderegister.domain;

import java.time.LocalDate;

/**
 * Factory-Klasse für Anträge aller Art
 */
public class AntragFactory {

    private final AntragRepository repository;

    public AntragFactory(AntragRepository repository) {
        this.repository = repository;
    }

    /**
     * Factory-Methode um aus primitiven Eingabedaten einen vollständigen Antrag zu erzeugen
     */
    public AnmeldungAntrag ausEingabedaten(String vorname, String nachname, String strasse, String hausnummer, String stadt, String plz, LocalDate geburtsdatum, String personalausweisnummer) {
        Vorname v = new Vorname(vorname);
        Nachname n = new Nachname(nachname);
        Strasse s = new Strasse(strasse);
        Hausnummer h = new Hausnummer(hausnummer);
        Ort o = new Ort(stadt);
        Postleitzahl p = new Postleitzahl(plz);
        Adresse a = new Adresse(s, h, p, o);
        Geburtsdatum g = new Geburtsdatum(geburtsdatum);
        Personalausweisnummer pa = new Personalausweisnummer(personalausweisnummer);
        Person person = new Person(v, n, a, g, pa);
        return new AnmeldungAntrag(repository, person);
    }
}
