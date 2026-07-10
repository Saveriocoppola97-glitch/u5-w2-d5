package save.u5_w2_d5.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionsHandler {

    // CONTROLLO DATI INSERITI
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationErrors(MethodArgumentNotValidException e) {
        Map<String, String> errore = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(err ->
                errore.put(err.getField(), err.getDefaultMessage())
        );
        return errore;
    }

    // ERRORE 404
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFound(RuntimeException e) {
        return Map.of("errore", e.getMessage());
    }
}