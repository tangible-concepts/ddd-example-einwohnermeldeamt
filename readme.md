# DDD Example 'Einwohnermeldeamt'

Dieses Beispiel zeigt eine exemplarische Implementierung stark vereinfachter Anwendungsfälle für ein fiktives 
kommunales Einwohnermeldeamt. Es dient als Anschauungsobjekt um Konzepte des DDD Tactical Design zu verdeutlichen.

Die Beispielimplementierung enthält bewusst einige Lücken und Unschärfen, um eine inhaltliche Auseinandersetzung 
mit den gewählten Ansätzen zu ermöglichen. Sie erhebt nicht den Anspruch einer Musterlösung. 

Das Domain Model reflektiert eine in Deutsch formulierte Ubiquitous Language.

## Fragestellungen

### Ereiterbarkeit

1. Wie können neue Anwendungsfälle (Ummeldung, Abmeldung) hinzugefügt werden?

### Testbarkeit

1. Wie wirkt sich die isolierte Testbarkeit der Domänenlogik auf die Testbarkeit der Anwendung aus?
2. Welche Tests werden sinnvollerweise auf Ebene des Domain Models, welche auf Ebene der Application Services geschrieben?

### Wartbarkeit

1. Wie könnte der Bounded Context weiter aufgespalten werden? Welche 'Bruchkanten' sind erkennbar?

### Lesbarkeit

1. Das Domain Model ist auf Deutsch gehalten. Welche Vor- und Nachteile sind (subjektiv) damit verbunden?
2. Manche Begriffe sind dennoch in Englisch (Event, Repository, publish()). Was ist deren Gemeinsamkeit?

### Robustheit

1. Wie könnte die Anwendung von der Einführung einer zentralen Fehlerbehandlung (z.B. Exception Fassaden) profitieren?
   1. Welche Fehler sollten innerhalb, welche außerhalb des Domain Models behandelt werden? Warum? Welche Trade Offs existieren?

### Implementierung

1. Welche Implikationen bringt die Abbildung der Aspekte Instanzbildung, Eventing und Validierung durch ein Framework (Spring, Quarkus, ...) mit sich?
2. Wie beeinflusst die in Deutsch gehaltene Ubiquitous Language die Implementierung? 
   1. Ergeben sich daraus Trade-Offs?
3. Wie würde eine Spring-Implementierung aussehen? Welche Vor- und Nachteile ergeben sich daraus?
   1. Instanzbildung (Dependency Injection)
   2. Validierung (Bean Validation)
   3. Eventing (Application Events)
   4. Fehlerbehandlung (Exception Handling via AOP / Interceptors / ...)
   5. Transaktionen (Declarative Transaction Management)
4. Event-basierte Kommunikation entkoppelt die Bausteine voneinander.
   1. Welche Vorteile bietet das im Vergleich zum direkten Aufruf am Beispiel des Aggregates 'AnmeldungAntrag'?
   2. Welche Nachteile ergeben sich daraus, z.b. beim Debugging? 

### Fachliche Konzepte

1. Wie könnten fachliche Fehler (z. B. Ablehnung ungültiger Adressen) von technischen (NULL-Referenzen) getrennt werden?
   1. Welche Begriffe sollten Teil der Ubiquitous Language sein / werden?
   2. Wie könnte die Fehlerbehandlung verbessert werden?