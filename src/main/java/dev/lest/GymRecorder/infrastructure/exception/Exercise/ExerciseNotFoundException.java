package dev.lest.GymRecorder.infrastructure.exception.Exercise;

public class ExerciseNotFoundException extends RuntimeException {
    public ExerciseNotFoundException(String message) {
        super(message);
    }
    public ExerciseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
