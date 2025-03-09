package de.tngbl.ewm.application;

import de.tngbl.ewm.domain.antragswesen.Antragsnummer;
import de.tngbl.ewm.domain.melderegister.Antragsverarbeitung;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Dieser Application Service realisiert den Use Case "Anmeldung verarbeiten".
 */
public class AnmeldungVerarbeiten {

    private final Antragsverarbeitung antragsverarbeitung;

    public AnmeldungVerarbeiten(Antragsverarbeitung antragsverarbeitung) {
        this.antragsverarbeitung = antragsverarbeitung;
    }

    /**
     * Verarbeitet eine Anmeldung und gibt das Datum zurück, an dem der Antrag verarbeitet wurde
     */
    public LocalDateTime verarbeiten(String antragsnummer) {
        return antragsverarbeitung.anmeldung(new Antragsnummer(UUID.fromString(antragsnummer))).getEintragungsZeitpunkt();
    }
}
