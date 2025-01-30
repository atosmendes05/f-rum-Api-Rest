package forum.api.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum Categoria {
    TECNOLOGIA,
    ARTES,
    CIENCIA;

    @JsonCreator
    public static Categoria fromValue(String value) {
        return Arrays.stream(forum.api.domain.model.Categoria.values())
                .filter(e -> e.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid value: " + value));
    }
}