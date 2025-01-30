package forum.api.domain.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import forum.api.domain.model.StatusTopico;
import forum.api.domain.model.Topico;

import java.time.LocalDateTime;
import java.util.Optional;

public record TopicoListDto(String titulo, String mensagem, @JsonFormat(pattern = "dd/MM/yyyy HH:mm") LocalDateTime data_criacao, StatusTopico status, String autor, String curso) {

    public TopicoListDto(Topico topico){
        this(topico.getTitulo(),topico.getMensagem(),topico.getDataCriacao(),topico.getStatus(),topico.getAutor().getNome(),topico.getCurso().getNome());
    }

}
