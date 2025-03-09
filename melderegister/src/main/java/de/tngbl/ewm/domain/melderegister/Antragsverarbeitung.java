package de.tngbl.ewm.domain.melderegister;

import de.tngbl.ewm.domain.antragswesen.AnmeldungAntrag;
import de.tngbl.ewm.domain.antragswesen.AntragRepository;
import de.tngbl.ewm.domain.antragswesen.Antragsnummer;

/**
 * Dieser Domain Service bildet die fachliche Verarbeitung von Anträgen ab.
 */
public class Antragsverarbeitung {

    private final AntragRepository antragRepository;
    private final ZentralesPersonenregister zentralesPersonenregister;
    private final AdressValidierung adressValidierung;
    private final RegisterEintragRepository registerEintragRepository;

    public Antragsverarbeitung(AntragRepository antragRepository, ZentralesPersonenregister zentralesPersonenregister, AdressValidierung adressValidierung, RegisterEintragRepository registerEintragRepository) {
        this.antragRepository = antragRepository;
        this.zentralesPersonenregister = zentralesPersonenregister;
        this.adressValidierung = adressValidierung;
        this.registerEintragRepository = registerEintragRepository;
    }

    public RegisterEintrag anmeldung(Antragsnummer antragsnummer) {

        AnmeldungAntrag antragsdaten = antragRepository.read(antragsnummer);

        if (antragsdaten == null) {
            throw new IllegalArgumentException("Antrag nicht gefunden: %s".formatted(antragsnummer));
        }

        if (! zentralesPersonenregister.isMeldefaehig(antragsdaten.getPerson())) {
            throw new IllegalArgumentException("Person ist nicht meldefähig: %s".formatted(antragsdaten.getPerson()));
        }

        Meldeadresse meldeadresse = meldadresseAusAntrag(antragsdaten);

        if (! adressValidierung.isValide(meldeadresse)) {
            throw new IllegalArgumentException("Meldeadresse ist nicht valide: %s".formatted(meldeadresse));
        }

        RegisterEintrag registerEintrag =  new RegisterEintrag(antragsdaten.getPerson(), meldeadresse);

        return registerEintragRepository.create(registerEintrag);

    }

    private Meldeadresse meldadresseAusAntrag(AnmeldungAntrag antragsdaten) {
        return new Meldeadresse(antragsdaten.getPerson().adresse().strasse(),
                antragsdaten.getPerson().adresse().hausnummer(),
                antragsdaten.getPerson().adresse().plz(),
                antragsdaten.getPerson().adresse().ort());
    }
}
