package pe.edu.upc.profiles_service.shared.interfaces.rest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResource> handleIllegalArgumentException(
            IllegalArgumentException exception,
            HttpServletRequest request) {
        return ResponseEntity.badRequest().body(error(exception.getMessage(), request));
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResource> handleIllegalStateException(
            IllegalStateException exception,
            HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error(exception.getMessage(), request));
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResource> handleResponseStatusException(
            ResponseStatusException exception,
            HttpServletRequest request) {
        return ResponseEntity.status(exception.getStatusCode())
                .body(error(exception.getReason(), request));
    }

    private ErrorResource error(String message, HttpServletRequest request) {
        return new ErrorResource(Instant.now(), message, request.getRequestURI());
    }
}
