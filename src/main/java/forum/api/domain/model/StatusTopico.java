package forum.api.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

public enum StatusTopico {
    ABERTO,
    FECHADO,
    ARQUIVADO;

    @JsonCreator
    public static StatusTopico fromValue(String value) {
        return Arrays.stream(StatusTopico.values())
                .filter(e -> e.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid value: " + value));
    }
}
