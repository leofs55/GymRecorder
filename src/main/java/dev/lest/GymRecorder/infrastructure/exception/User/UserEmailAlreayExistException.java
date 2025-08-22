package dev.lest.GymRecorder.infrastructure.exception.User;

public class UserEmailAlreayExistException extends RuntimeException {
    public UserEmailAlreayExistException(String message) {
        super(message);
    }

    public UserEmailAlreayExistException(String message, Throwable cause) {
    super(message, cause);
  }
}
