package de.tngbl.ewm.melderegister.domain.antragswesen;

/**
 * Aggregate Root (Entity) des Aggregate "Antrag auf Anmeldung einer Person".
 *
 */
public class AnmeldungAntrag {

    private final AntragRepository repository;

    private Antragsnummer antragsnummer = null;
    private final Person person;

    public AnmeldungAntrag(AntragRepository repository, Person person) {
        this.repository = repository;
        this.person = person;
    }

    public Antragsnummer einreichen() {

        repository.create(this);
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
