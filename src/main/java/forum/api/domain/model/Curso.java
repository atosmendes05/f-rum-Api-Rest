package forum.api.domain.model;

import forum.api.domain.DTO.CursoDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(){}

    public Curso(@Valid CursoDto cursoDto){
        this.nome = cursoDto.nome();
        this.categoria = Categoria.fromValue(String.valueOf(cursoDto.categoria()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria=" + categoria +
                '}';
    }
}
