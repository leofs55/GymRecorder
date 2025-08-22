package dev.lest.GymRecorder.infrastructure.exception.Exercise;

public class UserNotFoundInExerciseCreationException extends RuntimeException {
    public UserNotFoundInExerciseCreationException(String message) {
        super(message);
    }

    public UserNotFoundInExerciseCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
