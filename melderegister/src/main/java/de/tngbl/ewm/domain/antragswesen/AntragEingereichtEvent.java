package de.tngbl.ewm.domain.antragswesen;

import de.tngbl.ewm.domain.eventbus.DomainEvent;

public class AntragEingereichtEvent extends DomainEvent {

    private final AnmeldungAntrag anmeldungAntrag;

    public AntragEingereichtEvent(AnmeldungAntrag anmeldungAntrag) {
        this.anmeldungAntrag = anmeldungAntrag;
    }

    public AnmeldungAntrag getAnmeldungAntrag() {
        return anmeldungAntrag;
    }
}
