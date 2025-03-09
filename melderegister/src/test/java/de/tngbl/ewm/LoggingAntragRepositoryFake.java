package de.tngbl.ewm;

import de.tngbl.ewm.domain.antragswesen.AnmeldungAntrag;
import de.tngbl.ewm.domain.antragswesen.AntragRepository;
import de.tngbl.ewm.domain.antragswesen.Antragsnummer;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class LoggingAntragRepositoryFake implements AntragRepository {

    private final Map<Antragsnummer, AnmeldungAntrag> antraege = new ConcurrentHashMap<>();

    @Override
    public AnmeldungAntrag create(AnmeldungAntrag anmeldungAntrag) {

        anmeldungAntrag.setAntragsnummer(new Antragsnummer(UUID.randomUUID()));
        antraege.put(anmeldungAntrag.getAntragsnummer(), anmeldungAntrag);
        System.out.println("Antrag erstellt: " + anmeldungAntrag.getAntragsnummer());
        return anmeldungAntrag;
    }

    @Override
    public AnmeldungAntrag read(Antragsnummer antragsnummer) {

        if (antraege.containsKey(antragsnummer)) {
            System.out.println("Antrag gelesen: " + antragsnummer);
            return antraege.get(antragsnummer);
        } else {
            System.out.println("Antrag nicht gefunden: " + antragsnummer);
            return null;
        }
    }

    @Override
    public AnmeldungAntrag update(AnmeldungAntrag anmeldungAntrag) {

        antraege.put(anmeldungAntrag.getAntragsnummer(), anmeldungAntrag);
        System.out.println("Antrag aktualisiert: " + anmeldungAntrag.getAntragsnummer());
        return anmeldungAntrag;
    }

    @Override
    public boolean delete(Antragsnummer antragsnummer) {

        antraege.remove(antragsnummer);
        System.out.println("Antrag gelöscht: " + antragsnummer);
        return true;
    }
}
