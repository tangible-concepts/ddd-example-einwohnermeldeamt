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
   3. Ergeben sich daraus Trade-Offs?

### Fachliche Konzepte

1. Wie könnten fachliche Fehler (z. B. Ablehnung ungültiger Adressen) von technischen (NULL-Referenzen) getrennt werden?
   1. Welche Begriffe sollten Teil der Ubiquitous Language sein / werden?
   2. Wie könnte die Fehlerbehandlung verbessert werden?