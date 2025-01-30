package forum.api.domain.DTO;

import forum.api.domain.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoDto(

        @NotBlank
        String nome,

        @NotNull
        Categoria categoria) {
}
