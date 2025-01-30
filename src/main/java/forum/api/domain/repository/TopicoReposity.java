package forum.api.domain.repository;

import forum.api.domain.model.Topico;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoReposity extends JpaRepository<Topico,Long> {

    @Query("SELECT t FROM Topico t ORDER BY t.data_criacao ASC")
    Page<Topico> listaTopicosPorData(Pageable pageable);

    @Query("SELECT t FROM Topico t WHERE  t.id = :id ")
    Optional<Topico> BuscarTopicoPorId(Long id);

    Boolean existsByTitulo(@NotNull String titulo);

    Boolean existsByMensagem(@NotNull String mensagem);
}
