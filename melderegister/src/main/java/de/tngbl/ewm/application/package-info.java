/**
 * Application Services nutzen das Domain Model um Use Cases zu realisieren.
 * Jeder Application Service realisiert einen Use Case der Anwendung.
 * Application Services exponieren keine Details des Domainmodels nach außen.
 *
 * Die fachliche Korrektheit der Implementierung der Use Cases kann ohne externe Abhängigkeiten getestet werden,
 * indem die entsprechenden Interfaces mit Mocks, Fakes und Stubs implementiert werden.
 */
package de.tngbl.ewm.application;