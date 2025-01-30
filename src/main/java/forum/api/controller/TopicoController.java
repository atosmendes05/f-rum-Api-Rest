package forum.api.controller;

import forum.api.domain.DTO.TopicoDto;
import forum.api.domain.DTO.TopicoInforDto;
import forum.api.domain.DTO.TopicoListDto;
import forum.api.domain.DTO.TopicoUpdateDto;
import forum.api.domain.model.Topico;
import forum.api.domain.repository.CursoRepository;
import forum.api.domain.repository.TopicoReposity;
import forum.api.domain.repository.UsuarioRepository;
import forum.api.infra.exception.ValidacaoException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    TopicoReposity topicoReposity;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity criarTopico(@RequestBody @Valid TopicoDto topicoDto){
        var topico = new Topico(topicoDto);
        topico.setAutor(usuarioRepository.getReferenceById(topicoDto.autor()));
        topico.setCurso(cursoRepository.getReferenceById(topicoDto.curso()));
        topicoReposity.save(topico);

        return ResponseEntity.noContent().build();
    }


    @GetMapping
    public ResponseEntity<Page<TopicoListDto>>listaTopicos(@PageableDefault(size = 10,sort = {"titulo"})Pageable paginacao){
        var page = topicoReposity.listaTopicosPorData(paginacao).map(TopicoListDto::new);

        return ResponseEntity.ok(page);
    }


    @GetMapping("/id={id}")
    public ResponseEntity buscarTopico(@PathVariable(required = false) Long id) {
        if (id == null || id <= 0 ){
            throw new ValidacaoException("Erro: precissa passa ID!");
        }
        var topico = new TopicoListDto(topicoReposity.getReferenceById(id));

        return ResponseEntity.ok(topico);
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarTopico(@PathVariable(required = false) Long id,@RequestBody @Valid TopicoUpdateDto topicoUpdate){
        if (id == null || id <= 0){
            throw new ValidacaoException("Erro: é preciso passa ID!");
        }

        var topico = topicoReposity.BuscarTopicoPorId(id);
        if (topico.isPresent()){
            var t = topico.get();
            t.updateTopico(topicoUpdate);
            return ResponseEntity.ok(new TopicoInforDto(t));
        }

        throw new ValidacaoException("Topico não encontrado!");
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarTopico(@PathVariable(required = false) Long id){
        if (id == null || id <= 0){
            throw new ValidacaoException("Erro: é preciso passa ID!");
        }

        var topico = topicoReposity.BuscarTopicoPorId(id);
        if (topico.isPresent()){
            topicoReposity.deleteById(id);
            return ResponseEntity.ok("Topico deletado com sucesso");
        }

        throw new ValidacaoException("Topico não existe!");
    }




}
