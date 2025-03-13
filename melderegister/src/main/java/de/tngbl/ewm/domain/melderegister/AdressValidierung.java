package de.tngbl.ewm.domain.melderegister;

/**
 * Domain Service zur Validierung von Adressen.
 */
public interface AdressValidierung {

    boolean isValide(Meldeadresse meldeadresse);

}
