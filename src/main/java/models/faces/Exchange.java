package models.faces;

import java.util.Map;

public interface Exchange<T> {
    String name();

    Map<String, T> listedComponents();

    default T getComponent(String identifier) {
        return listedComponents().get(identifier);
    }

    void list(T stock);
}
