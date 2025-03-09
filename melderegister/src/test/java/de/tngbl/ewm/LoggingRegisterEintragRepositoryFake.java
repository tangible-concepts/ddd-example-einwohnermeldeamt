package de.tngbl.ewm;

import de.tngbl.ewm.domain.melderegister.RegisterEintrag;
import de.tngbl.ewm.domain.melderegister.RegisterEintragRepository;
import de.tngbl.ewm.domain.melderegister.RegistereintragNummer;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class LoggingRegisterEintragRepositoryFake implements RegisterEintragRepository {

    private final Map<RegistereintragNummer, RegisterEintrag> registerEintraege = new HashMap<>();

    @Override
    public RegisterEintrag create(RegisterEintrag registerEintrag) {

        registerEintrag.setRegistereintragNummer(RegistereintragNummer.neu());
        registerEintrag.setEintragungsZeitpunkt(LocalDateTime.now());
        registerEintraege.put(registerEintrag.getRegistereintragNummer(), registerEintrag);
        System.out.println("Eintrag erstellt: " + registerEintrag);
        return registerEintrag;
    }

    @Override
    public RegisterEintrag read(RegistereintragNummer registereintragNummer) {

        if (registerEintraege.containsKey(registereintragNummer)) {
            System.out.println("Eintrag gelesen: " + registerEintraege.get(registereintragNummer));
            return registerEintraege.get(registereintragNummer);
        } else {
            System.out.println("Eintrag nicht gefunden: " + registereintragNummer);
            return null;
        }
    }

    @Override
    public RegisterEintrag update(RegisterEintrag registerEintrag) {

        registerEintraege.put(registerEintrag.getRegistereintragNummer(), registerEintrag);
        System.out.println("Eintrag aktualisiert: " + registerEintrag);
        return registerEintrag;
    }

    @Override
    public boolean delete(RegistereintragNummer registereintragNummer) {

        registerEintraege.remove(registereintragNummer);
        System.out.println("Eintrag gelöscht: " + registerEintraege.get(registereintragNummer));
        return true;
    }
}
