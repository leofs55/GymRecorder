package dev.lest.GymRecorder.infrastructure.presentation.ControllerAdvices;

import dev.lest.GymRecorder.infrastructure.exception.Training.TrainingNotFoundException;
import dev.lest.GymRecorder.infrastructure.exception.Training.UserNotFoundTrainingCreateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class TrainingExceptionHandler {

    @ExceptionHandler(TrainingNotFoundException.class)
    public ResponseEntity<Map<String, Object>> TrainingNotFoundExceptionHandler(TrainingNotFoundException exception) {
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", exception.getMessage());
        responseHashMap.put("Error:", exception.getStackTrace());
        return ResponseEntity.ok(responseHashMap);
    }

    @ExceptionHandler(UserNotFoundTrainingCreateException.class)
    public ResponseEntity<Map<String, Object>> UserNotFoundTrainingCreateExceptionHandler(UserNotFoundTrainingCreateException exception) {
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", exception.getMessage());
        responseHashMap.put("Error:", exception.getStackTrace());
        return ResponseEntity.ok(responseHashMap);
    }
}
