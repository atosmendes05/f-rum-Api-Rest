package forum.api.domain.DTO;

import forum.api.domain.model.StatusTopico;
import jakarta.validation.constraints.NotNull;

public record TopicoUpdateDto(@NotNull String titulo, @NotNull String mensagem, StatusTopico status) {
}
