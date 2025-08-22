package dev.lest.GymRecorder.infrastructure.exception.Exercise;

public class UserDoesNotMatchForUpdateException extends RuntimeException {
    public UserDoesNotMatchForUpdateException(String message) {
        super(message);
    }
    public UserDoesNotMatchForUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

}
