package de.tngbl.ewm.melderegister.application;

import de.tngbl.ewm.melderegister.domain.AnmeldungAntrag;
import de.tngbl.ewm.melderegister.domain.AntragFactory;
import de.tngbl.ewm.melderegister.domain.Antragsnummer;

import java.time.LocalDate;

/**
 * Dieser Application Service realisiert den Use Case "Anmeldung beantragen"
 */
public class AnmeldungBeantragen {

    private final AntragFactory antragFactory;

    public AnmeldungBeantragen(AntragFactory antragFactory) {
        this.antragFactory = antragFactory;
    }

    /***
     * Improvements: Bean Validation nutzen, um die Parameter zu validieren
     */
    public String antragStellen(String vorname, String nachname, String strasse, String hausnummer, String stadt, String plz, LocalDate geburtsdatum, String personalausweisnummer) {

        AnmeldungAntrag antrag = antragFactory.ausEingabedaten(vorname, nachname, strasse, hausnummer, stadt, plz, geburtsdatum, personalausweisnummer);
        Antragsnummer antragsnummer = antrag.einreichen();
        return antragsnummer.toString();
    }
}
