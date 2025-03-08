package de.tngbl.ewm.melderegister.application;

import de.tngbl.ewm.melderegister.domain.antragswesen.AnmeldungAntrag;
import de.tngbl.ewm.melderegister.domain.antragswesen.AntragRepository;
import de.tngbl.ewm.melderegister.domain.antragswesen.Antragsnummer;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class LoggingAntragRepositoryFake implements AntragRepository {

    private final Map<Antragsnummer, AnmeldungAntrag> antraege = new ConcurrentHashMap<>();

    @Override
    public void create(AnmeldungAntrag anmeldungAntrag) {
        anmeldungAntrag.setAntragsnummer(new Antragsnummer(UUID.randomUUID()));
        antraege.put(anmeldungAntrag.getAntragsnummer(), anmeldungAntrag);
        System.out.println("Antrag erstellt: " + anmeldungAntrag.getAntragsnummer());
    }

    @Override
    public AnmeldungAntrag read(Antragsnummer antragsnummer) {
        return antraege.get(antragsnummer);
    }

    @Override
    public void update(AnmeldungAntrag anmeldungAntrag) {
        antraege.put(anmeldungAntrag.getAntragsnummer(), anmeldungAntrag);
        System.out.println("Antrag aktualisiert: " + anmeldungAntrag.getAntragsnummer());
    }

    @Override
    public void delete(Antragsnummer antragsnummer) {
        antraege.remove(antragsnummer);
        System.out.println("Antrag gelöscht: " + antragsnummer);
    }
}
