package dev.lest.GymRecorder.infrastructure.exception.User;

public class PasswordDontMatchDeleteException extends RuntimeException {
    public PasswordDontMatchDeleteException(String message) {
        super(message);
    }
    public PasswordDontMatchDeleteException(String message, Throwable cause) {
    super(message, cause);
  }
}
