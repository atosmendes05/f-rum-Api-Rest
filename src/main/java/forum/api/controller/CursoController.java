package forum.api.controller;

import forum.api.domain.DTO.CursoDto;
import forum.api.domain.model.Curso;
import forum.api.domain.repository.CursoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    CursoRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastraCurso(@RequestBody @Valid CursoDto cursoDto){
        var curso = new Curso(cursoDto);
        repository.save(curso);

        return ResponseEntity.noContent().build();
    }

}
