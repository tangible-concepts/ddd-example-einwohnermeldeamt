package de.tngbl.ewm.application;


import de.tngbl.ewm.LoggingAntragRepositoryFake;
import de.tngbl.ewm.domain.antragswesen.AntragFactory;
import de.tngbl.ewm.domain.antragswesen.AntragRepository;
import de.tngbl.ewm.integration.eventing.LoggingEventPublisher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AnmeldungBeantragenTest {

    @BeforeAll
    static void setUpEventPublisher() {
        new LoggingEventPublisher();
    }

    @Test
    @DisplayName("Happy Path")
    void shouldCreateAnmeldung() {

        // given
        AntragRepository antragRepository = LoggingAntragRepositoryFake.getInstance();
        AnmeldungBeantragen anmeldungBeantragen = new AnmeldungBeantragen(new AntragFactory());

        // when
        String antragsnummer = anmeldungBeantragen.antragStellen("Max", "Mustermann", "Musterstraße", "1", "Musterstadt", "12345", LocalDate.of(2000, 1, 1), "1234567890");

        // then
        assertFalse(antragsnummer.isEmpty());
    }

    @Test
    @DisplayName("Geburtsdatum in der Zukunft wird abgelehnt")
    void shouldRaiseException() {

        // given
        AntragRepository antragRepository = LoggingAntragRepositoryFake.getInstance();
        AnmeldungBeantragen anmeldungBeantragen = new AnmeldungBeantragen(new AntragFactory());

        // when
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () ->  anmeldungBeantragen.antragStellen("Max", "Mustermann", "Musterstraße", "1", "Musterstadt", "12345", LocalDate.of(2032, 1, 1), "1234567890"));

        // then
        assertTrue(ex.getLocalizedMessage().contains("Zukunft"));
    }

}