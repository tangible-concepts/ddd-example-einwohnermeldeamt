package de.tngbl.ewm.melderegister.application;


import de.tngbl.ewm.melderegister.domain.AntragFactory;
import de.tngbl.ewm.melderegister.domain.AntragRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;

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

}