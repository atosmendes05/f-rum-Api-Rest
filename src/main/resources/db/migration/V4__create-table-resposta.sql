CREATE TABLE respostas (
    id BIGSERIAL NOT NULL,
    mensagem VARCHAR(200) NOT NULL,
    topico_id BIGSERIAL NOT NULL,
    dataCriacao TIMESTAMP NOT NULL,
    autor_id BIGSERIAL NOT NULL,
    solucao BOOLEAN not null,

    PRIMARY KEY (id),
    CONSTRAINT fk_respostas_topico_id FOREIGN KEY (topico_id) REFERENCES topicos (id),
    CONSTRAINT fk_respostas_autor_id FOREIGN KEY (autor_id) REFERENCES usuarios (id)
);