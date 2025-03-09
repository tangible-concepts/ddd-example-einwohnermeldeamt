package de.tngbl.ewm;

import de.tngbl.ewm.domain.melderegister.AdressValidierung;
import de.tngbl.ewm.domain.melderegister.Meldeadresse;

/**
 * Simuliert die Anbindung eines externen Dienstes zur Adressvalidierung.
 *
 */
public class AdressValidierungMock implements AdressValidierung {

    /**
     * Simuliert die Adressvalidierung, liefert False zurück, wenn die Hausnummer mit 9 beginnt
     */
    @Override
    public boolean isValide(Meldeadresse meldeadresse) {
        return meldeadresse.getHausnummer().value().charAt(0) != '9';
    }

}
