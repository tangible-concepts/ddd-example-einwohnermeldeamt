package de.tngbl.ewm.application;


import de.tngbl.ewm.LoggingAntragRepositoryFake;
import de.tngbl.ewm.domain.antragswesen.AntragFactory;
import de.tngbl.ewm.domain.antragswesen.AntragRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AnmeldungBeantragenTest {

    @Test
    @DisplayName("Happy Path")
    void shouldCreateAnmeldung() {

        // given
        AntragRepository antragRepository = new LoggingAntragRepositoryFake();
        AnmeldungBeantragen anmeldungBeantragen = new AnmeldungBeantragen(new AntragFactory(antragRepository));

        // when
        String antragsnummer = anmeldungBeantragen.antragStellen("Max", "Mustermann", "Musterstraße", "1", "Musterstadt", "12345", LocalDate.of(2000, 1, 1), "1234567890");

        // then
        assertFalse(antragsnummer.isEmpty());
    }

    @Test
    @DisplayName("Geburtsdatum in der Zukunft wird abgelehnt")
    void shouldRaiseException() {

        // given
        AntragRepository antragRepository = new LoggingAntragRepositoryFake();
        AnmeldungBeantragen anmeldungBeantragen = new AnmeldungBeantragen(new AntragFactory(antragRepository));

        // when
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->  anmeldungBeantragen.antragStellen("Max", "Mustermann", "Musterstraße", "1", "Musterstadt", "12345", LocalDate.of(2032, 1, 1), "1234567890"));

        // then
        assertTrue(ex.getLocalizedMessage().contains("Zukunft"));
    }

}