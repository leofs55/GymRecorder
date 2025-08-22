package dev.lest.GymRecorder.infrastructure.exception.Training;

public class UserNotFoundTrainingCreateException extends RuntimeException {
  public UserNotFoundTrainingCreateException(String message) {
    super(message);
  }
  public UserNotFoundTrainingCreateException(String message, Throwable cause) {
    super(message, cause);
  }
}
