package de.tngbl.ewm.domain.melderegister;

import de.tngbl.ewm.domain.basisdaten.Person;

import java.time.LocalDateTime;

/**
 * Aggregate Root (Entity) des Aggregates "Gemeldete Person".
 */
public class RegisterEintrag {

    private RegistereintragNummer registereintragNummer;
    private final Person gemeldetePerson;
    private final Meldeadresse meldeadresse;
    private LocalDateTime eintragungsZeitpunkt;

    public RegisterEintrag(Person person, Meldeadresse meldeadresse) {

        this.gemeldetePerson = person;
        this.meldeadresse = meldeadresse;
    }


    public RegistereintragNummer getRegistereintragNummer() {
        return registereintragNummer;
    }

    public void setRegistereintragNummer(RegistereintragNummer registereintragNummer) {
        this.registereintragNummer = registereintragNummer;
    }

    public Person getGemeldetePerson() {
        return gemeldetePerson;
    }

    public Meldeadresse getMeldeadresse() {
        return meldeadresse;
    }

    public LocalDateTime getEintragungsZeitpunkt() {
        return eintragungsZeitpunkt;
    }

    public void setEintragungsZeitpunkt(LocalDateTime eintragungsZeitpunkt) {
        this.eintragungsZeitpunkt = eintragungsZeitpunkt;
    }

    @Override
    public String toString() {
        return "RegisterEintrag{" +
                "registereintragNummer=" + registereintragNummer +
                ", gemeldetePerson=" + gemeldetePerson +
                ", meldeadresse=" + meldeadresse +
                ", eintragungsZeitpunkt=" + eintragungsZeitpunkt +
                '}';
    }
}
