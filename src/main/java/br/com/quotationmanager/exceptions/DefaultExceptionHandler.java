package br.com.quotationmanager.exceptions;

import br.com.quotationmanager.model.dto.ErrorResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@Slf4j
@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<?> notFoundException(NotFoundException ex) {
        log.error(ex.getMessage(), ex);
        return buildResponse(HttpStatus.NOT_FOUND, ex);
    }

    public ResponseEntity<ErrorResponseDTO> buildResponse(
            HttpStatus statusCode, Exception exception) {
        ErrorResponseDTO errorResponse =
                new ErrorResponseDTO("Failed", List.of(exception.getLocalizedMessage()));
        return new ResponseEntity(errorResponse, statusCode);
    }

    public ResponseEntity<?> buildResponse(HttpStatus statusCode, String response) {
        log.error("buildResponse response {}", response);
        return new ResponseEntity(response, statusCode);
    }
}
