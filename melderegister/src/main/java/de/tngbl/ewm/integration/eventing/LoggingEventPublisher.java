package de.tngbl.ewm.integration.eventing;

import de.tngbl.ewm.domain.antragswesen.AntragEingereichtEvent;
import de.tngbl.ewm.domain.eventbus.EventBus;

/**
 * Dieser Publisher gibt Events in der Konsole aus.
 * Er ist ein Beispiel dafür wie Domain Events in andere Systeme integriert werden können, ohne Abhängigkeiten auf das interne Domain Model zu schaffen.
 * Bei den emittiereten Events kann es sich auch um Projektionen handeln, z.b. die Information wieviele Anträge in einem bestimmten Zeitraum eingegangen sind.
 *
 * Eine reale Integration würde hier z.B. eine Schnittstelle zu einem Message Broker oder einer Datenbank implementieren.
 */
public class LoggingEventPublisher {

    public LoggingEventPublisher() {
        EventBus.register(AntragEingereichtEvent.class, this::notifyExternalSystems);
    }

    public void notifyExternalSystems(AntragEingereichtEvent event) {

        System.out.printf("Neue Person: %s%n", event.getAnmeldungAntrag().getPerson());
        System.out.printf("Neue Adresse: %s%n", event.getAnmeldungAntrag().getPerson().adresse());

    }
}
