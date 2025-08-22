package dev.lest.GymRecorder.infrastructure.exception.Exercise;

public class ExerciseNotFoundInFindAllByListIdException extends RuntimeException {
    public ExerciseNotFoundInFindAllByListIdException(String message) {
        super(message);
    }
    public ExerciseNotFoundInFindAllByListIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
