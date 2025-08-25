package dev.lest.GymRecorder.infrastructure.presentation.ControllerAdvices;

import dev.lest.GymRecorder.infrastructure.exception.Exercise.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExerciseExceptionHandler {

    @ExceptionHandler(ExerciseNotFoundException.class)
    public ResponseEntity<Map<String, Object>> ExerciseNotFoundExceptionHandler(ExerciseNotFoundException exception) {
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", exception.getMessage());
        responseHashMap.put("Error:", exception.getStackTrace());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseHashMap);
    }

    @ExceptionHandler(ExerciseNotFoundInFindAllByListIdException.class)
    public ResponseEntity<Map<String, Object>> ExerciseNotFoundInFindAllByListIdExceptionHandler(ExerciseNotFoundInFindAllByListIdException exception) {
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", exception.getMessage());
        responseHashMap.put("Error:", exception.getStackTrace());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseHashMap);
    }

    @ExceptionHandler(UserDoesNotMatchForUpdateException.class)
    public ResponseEntity<Map<String, Object>> UserDoesNotMatchForUpdateExceptionHandler(UserDoesNotMatchForUpdateException exception) {
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", exception.getMessage());
        responseHashMap.put("Error:", exception.getStackTrace());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(responseHashMap);    }

    @ExceptionHandler(UserNotFoundInExerciseCreationException.class)
    public ResponseEntity<Map<String, Object>> UserNotFoundInExerciseCreationExceptionHandler(UserNotFoundInExerciseCreationException exception) {
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", exception.getMessage());
        responseHashMap.put("Error:", exception.getStackTrace());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseHashMap);
    }

    @ExceptionHandler(UserNotFoundInExerciseDeleteException.class)
    public ResponseEntity<Map<String, Object>> UserNotFoundInExerciseDeleteExceptionHandler(UserNotFoundInExerciseDeleteException exception) {
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", exception.getMessage());
        responseHashMap.put("Error:", exception.getStackTrace());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseHashMap);
    }


}
