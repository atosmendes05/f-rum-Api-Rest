package forum.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> tratarErro404() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Topico não encontrado!");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(erros.stream().map(ErroValidacaoDto::new));
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity regraDeNegocio(ValidacaoException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> tratarValorDublicado(DataIntegrityViolationException ex) {
        return ResponseEntity.badRequest().body("Erro: Título ou mensagem já existem!");
    }




    private record ErroValidacaoDto(String campo,String mensagem){
        public ErroValidacaoDto(FieldError error){
            this(error.getField(),error.getDefaultMessage());
        }
    }
}
