CREATE TABLE topicos (
    id BIGSERIAL NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    mensagem VARCHAR(200) NOT NULL,
    dataCriacao TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL,
    autor_id BIGSERIAL NOT NULL,
    curso_id BIGSERIAL,

    PRIMARY KEY (id),
    CONSTRAINT fk_topicos_curso_id FOREIGN KEY (curso_id) REFERENCES cursos (id),
    CONSTRAINT fk_topicos_autor_id FOREIGN KEY (autor_id) REFERENCES usuarios (id)
);