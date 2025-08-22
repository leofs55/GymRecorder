package dev.lest.GymRecorder.infrastructure.exception.Exercise;

public class UserNotFoundInExerciseDeleteException extends RuntimeException {
    public UserNotFoundInExerciseDeleteException(String message) {
        super(message);
    }
    public UserNotFoundInExerciseDeleteException(String message, Throwable cause) {
    super(message, cause);
  }
}
