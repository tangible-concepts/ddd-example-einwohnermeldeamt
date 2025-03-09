package de.tngbl.ewm.application;

import de.tngbl.ewm.AdressValidierungMock;
import de.tngbl.ewm.LoggingAntragRepositoryFake;
import de.tngbl.ewm.LoggingRegisterEintragRepositoryFake;
import de.tngbl.ewm.ZentralesPersonenregisterMock;
import de.tngbl.ewm.domain.antragswesen.AnmeldungAntrag;
import de.tngbl.ewm.domain.antragswesen.AntragRepository;
import de.tngbl.ewm.domain.antragswesen.Antragsnummer;
import de.tngbl.ewm.domain.basisdaten.*;
import de.tngbl.ewm.domain.melderegister.Antragsverarbeitung;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AnmeldungsantragVerarbeitenTest {

    AntragRepository antragRepository = new LoggingAntragRepositoryFake();  //
    private AnmeldungAntrag anmeldungAntrag;    // Testobjekt

    @BeforeAll
    void setUpFakePersistence() {


        AnmeldungAntrag anmeldungAntrag = new AnmeldungAntrag(antragRepository, new Person(
                new Vorname("Max"),
                new Nachname("Mustermann"),
                new Adresse(
                        new Strasse("Musterstraße"),
                        new Hausnummer("1"),
                        new Postleitzahl("12345"),
                        new Ort("Musterstadt")
                ),
                new Geburtsdatum(LocalDate.now().minusYears(20)),
                new Personalausweisnummer("1234567890")
        ));

        antragRepository.create(anmeldungAntrag);
        this.anmeldungAntrag = anmeldungAntrag;
    }

    @Test
    @DisplayName("Happy Path")
    void shouldProcessAnmeldungsantrag() {

        // given
        Antragsverarbeitung antragsverarbeitung = new Antragsverarbeitung(this.antragRepository, new ZentralesPersonenregisterMock(), new AdressValidierungMock(), new LoggingRegisterEintragRepositoryFake());
        AnmeldungVerarbeiten anmeldungVerarbeiten = new AnmeldungVerarbeiten(antragsverarbeitung);

        // when
        LocalDateTime bearbeitungsdatum = anmeldungVerarbeiten.verarbeiten(anmeldungAntrag.getAntragsnummer().value().toString());

        // then
        assertTrue(LocalDateTime.now().isAfter(bearbeitungsdatum));
    }

    @Test
    @DisplayName("Nicht existente Antragsnummer führt zu Fehler")
    void shouldRaiseException() {

        // given
        Antragsverarbeitung antragsverarbeitung = new Antragsverarbeitung(this.antragRepository, new ZentralesPersonenregisterMock(), new AdressValidierungMock(), new LoggingRegisterEintragRepositoryFake());
        AnmeldungVerarbeiten anmeldungVerarbeiten = new AnmeldungVerarbeiten(antragsverarbeitung);

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> anmeldungVerarbeiten.verarbeiten(Antragsnummer.neu().toString()));

        // then
        assertTrue(exception.getLocalizedMessage().contains("Antrag nicht gefunden"));

    }

    @Test
    @DisplayName("Meldung nicht meldefähiger Personen muss abgelehnt werden")
    void shouldNotAccept() {

        // given
        Antragsverarbeitung antragsverarbeitung = new Antragsverarbeitung(this.antragRepository, new ZentralesPersonenregisterMock(), new AdressValidierungMock(), new LoggingRegisterEintragRepositoryFake());
        AnmeldungVerarbeiten anmeldungVerarbeiten = new AnmeldungVerarbeiten(antragsverarbeitung);
        var invalidPerson = new Person(
                new Vorname("Max"),
                new Nachname("Mustermann"),
                new Adresse(
                        new Strasse("Musterstraße"),
                        new Hausnummer("1"),
                        new Postleitzahl("12345"),
                        new Ort("Musterstadt")
                ),
                new Geburtsdatum(LocalDate.now().minusYears(20)),
                new Personalausweisnummer("1234567899") // triggert Ablehnung in Mock
        );
        var anmeldungInvalidPerson = new AnmeldungAntrag(antragRepository, invalidPerson).einreichen();

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> anmeldungVerarbeiten.verarbeiten(anmeldungInvalidPerson.value().toString()));

        // then
        assertTrue(exception.getLocalizedMessage().contains("Person ist nicht meldefähig"));
    }

    @Test
    @DisplayName("Invalide Adressen müssen abgelehnt werden")
    void shouldNotAcceptInvalidAddresses() {

        // given
        Antragsverarbeitung antragsverarbeitung = new Antragsverarbeitung(this.antragRepository, new ZentralesPersonenregisterMock(), new AdressValidierungMock(), new LoggingRegisterEintragRepositoryFake());
        AnmeldungVerarbeiten anmeldungVerarbeiten = new AnmeldungVerarbeiten(antragsverarbeitung);
        var invalidAddress = new Person(
                new Vorname("Max"),
                new Nachname("Mustermann"),
                new Adresse(
                        new Strasse("Musterstraße"),
                        new Hausnummer("91"),   // triggert Fehlschlag der Validierung in Mock
                        new Postleitzahl("12345"),
                        new Ort("Musterstadt")
                ),
                new Geburtsdatum(LocalDate.now().minusYears(20)),
                new Personalausweisnummer("1234567890")
        );
        var anmeldungInvalidAddress = new AnmeldungAntrag(antragRepository, invalidAddress).einreichen();


        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> anmeldungVerarbeiten.verarbeiten(anmeldungInvalidAddress.value().toString()));

        // then
        assertTrue(exception.getLocalizedMessage().contains("Meldeadresse ist nicht valide"));
    }
}

