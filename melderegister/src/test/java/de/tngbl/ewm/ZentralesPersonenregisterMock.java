package de.tngbl.ewm;

import de.tngbl.ewm.domain.basisdaten.Person;
import de.tngbl.ewm.domain.melderegister.ZentralesPersonenregister;

/**
 * Diese Klasse simuliert die anbindung an das zentrale Personenregister.
 * Sie gibt zurück, dass eine Person nicht meldefähig ist, wenn die letzte Ziffer der {@link de.tngbl.ewm.domain.basisdaten.Personalausweisnummer} eine 9 ist.
 */
public class ZentralesPersonenregisterMock implements ZentralesPersonenregister {

    @Override
    public boolean isMeldefaehig(Person person) {
        return person.personalausweisnummer().value().charAt(person.personalausweisnummer().value().length() - 1) != '9';
    }

}
