package de.tngbl.ewm.melderegister.domain.antragswesen;

/**
 * Repository für Anträge aller Art
 */
public interface AntragRepository {

    void create(AnmeldungAntrag anmeldungAntrag);

    AnmeldungAntrag read(Antragsnummer antragsnummer);

    void update(AnmeldungAntrag anmeldungAntrag);

    void delete(Antragsnummer antragsnummer);


}
