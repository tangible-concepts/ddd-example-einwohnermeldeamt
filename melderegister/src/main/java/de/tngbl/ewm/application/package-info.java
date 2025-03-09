/**
 * Jeder Application Services kapselt einen oder mehrere verwandte Use Cases, die das darunterliegende Domainmodel verwenden.
 * Application Services exponieren keine Details des Domainmodels nach außen.
 *
 * Die fachliche Korrektheit der Implementierung der Use Cases kann ohne externe Abhängigkeiten getestet werden,
 * indem die entsprechenden Interfaces mit Mocks, Fakes oder Stubs implementiert werden.
 */
package de.tngbl.ewm.application;