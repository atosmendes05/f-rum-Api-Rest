# Fórum API Restful
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)

## Descrição

Este projeto é uma API Restful para um fórum de cursos, onde os usuários podem criar, listar, atualizar e deletar tópicos, além de responder aos tópicos de outros usuários. A API utiliza autenticação via JWT e segue o modelo stateless para segurança.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Web** (para criação da API Rest)
- **Spring Security** (para autenticação e autorização)
- **Spring Data JPA** (para persistência de dados)
- **Flyway** (para versionamento do banco de dados)
- **PostgreSQL** (banco de dados relacional)
- **Bean Validation** (para validação dos dados de entrada)
- **Spring Boot DevTools** (para facilitar o desenvolvimento)
- **Autenticação JWT** (para autenticação stateless)

## Instalação e Configuração

### 1. Clonar o repositório
```sh
 git clone https://github.com/seu-usuario/seu-repositorio.git
 cd seu-repositorio
```

### 2. Configurar o Banco de Dados
Crie um banco de dados PostgreSQL e configure o `application.properties` ou `application.yml` com as credenciais corretas.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/forum
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=validate
spring.flyway.enabled=true
```

### 3. Executar o Projeto
```sh
mvn spring-boot:run
```

## Endpoints da API

### Autenticação
- `POST /login` → Autentica um usuário e retorna um token JWT
- `POST /cadastro` → Registra um novo usuário

### Tópicos
- `POST /topicos` → Cria um novo tópico
- `GET /topicos` → Lista todos os tópicos
- `GET /topicos/{id}` → Obtém um tópico específico
- `PUT /topicos/{id}` → Atualiza um tópico
- `DELETE /topicos/{id}` → Remove um tópico

### Respostas
- `POST /topicos/{id}/respostas` → Adiciona uma resposta a um tópico
- `GET /topicos/{id}/respostas` → Lista todas as respostas de um tópico

## Segurança
A API utiliza autenticação via JWT e segue o modelo stateless. Para acessar endpoints protegidos, é necessário incluir o token no cabeçalho da requisição:

```http
Authorization: Bearer {seu_token_jwt}
```

## Contribuição
1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b minha-feature`)
3. Faça commit das suas alterações (`git commit -m 'Adicionando nova funcionalidade'`)
4. Envie para o repositório (`git push origin minha-feature`)
5. Abra um Pull Request

---
Criado por [Atos Mendes](https://github.com/atosmendes05).
