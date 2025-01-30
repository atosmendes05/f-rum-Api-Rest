package forum.api.domain.model;

import forum.api.domain.DTO.TopicoDto;
import forum.api.domain.DTO.TopicoUpdateDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "topicos")
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @Column(unique = true)
    private String mensagem;

    private LocalDateTime data_criacao;

    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id",nullable = false)
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Curso curso;

    @OneToMany(mappedBy = "topico",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OrderBy("data_criacao DESC")
    private List<Resposta> respostas = new ArrayList<>();

    public Topico(){}

    public Topico(@Valid TopicoDto topicoDto){
        this.titulo = topicoDto.titulo();
        this.mensagem = topicoDto.mensagem();
        this.status = StatusTopico.fromValue("aberto");
        this.data_criacao = LocalDateTime.now();
    }

    public void updateTopico(@Valid TopicoUpdateDto topicoUpdate){
        if (topicoUpdate.titulo() != null){
            this.titulo = topicoUpdate.titulo();
        }

        if (topicoUpdate.mensagem() != null){
            this.mensagem = topicoUpdate.mensagem();
        }

        if (topicoUpdate.status() != null){
            this.status = topicoUpdate.status();
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return data_criacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.data_criacao = dataCriacao;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public void setStatus(StatusTopico status) {
        this.status = status;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    @Override
    public String toString() {
        return "Topico{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", dataCriacao=" + data_criacao +
                ", status=" + status +
                ", autor=" + autor +
                ", curso=" + curso +
                ", respostas=" + respostas +
                '}';
    }
}
