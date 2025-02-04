package forum.api.domain.DTO;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDto(@NotBlank String login , @NotBlank String senha) {
}
