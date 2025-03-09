package de.tngbl.ewm.domain.melderegister;

/**
 * Repository für RegisterEinträge.
 * Abstrahiert die Datenbankzugriffe auf RegisterEinträge.
 */
public interface RegisterEintragRepository {

    RegisterEintrag create(RegisterEintrag registerEintrag);

    RegisterEintrag read(RegistereintragNummer registereintragNummer);

    RegisterEintrag update(RegisterEintrag registerEintrag);

    boolean delete(RegistereintragNummer registereintragNummer);

}
