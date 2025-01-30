package forum.api.domain.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoDto(
        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotNull
        Long autor,

        @NotNull
        Long curso) {
}
