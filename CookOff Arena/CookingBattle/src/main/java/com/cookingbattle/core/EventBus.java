package com.cookingbattle.core;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EventBus {
    private final List<Consumer<String>> listeners = new ArrayList<>();

    public void subscribe(Consumer<String> listener) {
        listeners.add(listener);
    }

    public void emit(String event) {
        for (Consumer<String> listener : listeners) {
            listener.accept(event);
        }
    }
}
