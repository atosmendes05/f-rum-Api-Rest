ALTER TABLE topicos ADD CONSTRAINT unique_titulo UNIQUE (titulo);
ALTER TABLE topicos ADD CONSTRAINT unique_mensagem UNIQUE (mensagem);
