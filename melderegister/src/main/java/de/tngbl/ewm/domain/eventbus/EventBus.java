package de.tngbl.ewm.domain.eventbus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class EventBus {

    private final static Map<Class<? extends DomainEvent>, List<Consumer<DomainEvent>>> listeners = new ConcurrentHashMap<>();

    // Observer registrieren
    public static <T extends DomainEvent> void register(Class<T> eventType, Consumer<T> listener) {
        listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add((Consumer<DomainEvent>) listener);
    }

    // Event publizieren
    public static <T extends DomainEvent> void publish(T event) {
        List<Consumer<DomainEvent>> eventListeners = listeners.getOrDefault(event.getClass(), Collections.emptyList());
        eventListeners.forEach(listener -> {
            System.out.println("Stelle '%s' an '%s' zu!".formatted(event.getClass().getSimpleName(), listener.getClass().getSimpleName().split("\\$")[0]));
            listener.accept(event);
        });
    }
}
