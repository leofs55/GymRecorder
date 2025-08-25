package dev.lest.GymRecorder.infrastructure.presentation.ControllerAdvices;

import dev.lest.GymRecorder.infrastructure.exception.User.PasswordDontMatchDeleteException;
import dev.lest.GymRecorder.infrastructure.exception.User.UserEmailAlreayExistException;
import dev.lest.GymRecorder.infrastructure.exception.User.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(PasswordDontMatchDeleteException.class)
    public ResponseEntity<Map<String, Object>> PasswordDontMatchDeleteExceptionHandler(PasswordDontMatchDeleteException exception) {
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", exception.getMessage());
        responseHashMap.put("Error:", exception.getStackTrace());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseHashMap);
    }

    @ExceptionHandler(UserEmailAlreayExistException.class)
    public ResponseEntity<Map<String, Object>> UserEmailAlreayExistExceptionHandler(UserEmailAlreayExistException exception) {
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", exception.getMessage());
        responseHashMap.put("Error:", exception.getStackTrace());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseHashMap);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> UserNotFoundExceptionHandler(UserNotFoundException exception) {
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", exception.getMessage());
        responseHashMap.put("Error:", exception.getStackTrace());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseHashMap);
    }
}
