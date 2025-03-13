package de.tngbl.ewm.domain.melderegister;

import de.tngbl.ewm.domain.basisdaten.Person;

/**
 * Dieser Domain Service kapselt Zugriffe auf das zentrale Melderegister des
 * Bundes.
 */
public interface ZentralesPersonenregister {

    boolean isMeldefaehig(Person person);
}
