package de.tngbl.ewm.domain.antragswesen;

/**
 * Repository für Anträge.
 * Abstrahiert die Datenbankzugriffe auf Anträge.
 */
public interface AntragRepository {

    AnmeldungAntrag create(AnmeldungAntrag anmeldungAntrag);

    AnmeldungAntrag read(Antragsnummer antragsnummer);

    AnmeldungAntrag update(AnmeldungAntrag anmeldungAntrag);

    boolean delete(Antragsnummer antragsnummer);

}
