package de.tngbl.ewm.integration.persistence;

import de.tngbl.ewm.domain.antragswesen.AnmeldungAntrag;
import de.tngbl.ewm.domain.antragswesen.AntragRepository;
import de.tngbl.ewm.domain.antragswesen.Antragsnummer;

public class JdbcAntragRepository implements AntragRepository {

    @Override
    public AnmeldungAntrag create(AnmeldungAntrag anmeldungAntrag) {
        throw new UnsupportedOperationException("Noch nicht implementiert.");
    }

    @Override
    public AnmeldungAntrag read(Antragsnummer antragsnummer) {
        throw new UnsupportedOperationException("Noch nicht implementiert.");
    }

    @Override
    public AnmeldungAntrag update(AnmeldungAntrag anmeldungAntrag) {
        throw new UnsupportedOperationException("Noch nicht implementiert.");
    }

    @Override
    public boolean delete(Antragsnummer antragsnummer) {
        throw new UnsupportedOperationException("Noch nicht implementiert.");
    }

}
