package forum.api.domain.DTO;

import forum.api.domain.model.StatusTopico;
import forum.api.domain.model.Topico;

public record TopicoInforDto(String titulo, String mensagem, StatusTopico statusTopico) {
    public TopicoInforDto(Topico topico){
        this(topico.getTitulo(),topico.getMensagem(),topico.getStatus());
    }
}
