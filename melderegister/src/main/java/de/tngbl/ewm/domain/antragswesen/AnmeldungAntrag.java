package de.tngbl.ewm.domain.antragswesen;

import de.tngbl.ewm.domain.basisdaten.Person;
import de.tngbl.ewm.domain.eventbus.EventBus;

/**
 * Aggregate Root (Entity) des Aggregate "Antrag auf Anmeldung einer Person".
 *
 */
public class AnmeldungAntrag {

    private Antragsnummer antragsnummer = null;
    private final Person person;

    public AnmeldungAntrag(Person person) {
        this.person = person;
    }

    public Antragsnummer einreichen() {
        EventBus.publish(new AntragEingereichtEvent(this));
        return this.antragsnummer;
    }

    public Antragsnummer getAntragsnummer() {
        return antragsnummer;
    }

    public void setAntragsnummer(Antragsnummer antragsnummer) {
        this.antragsnummer = antragsnummer;
    }

    public Person getPerson() {
        return person;
    }
}
