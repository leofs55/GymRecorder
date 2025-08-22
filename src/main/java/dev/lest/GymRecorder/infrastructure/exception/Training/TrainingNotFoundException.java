package dev.lest.GymRecorder.infrastructure.exception.Training;

public class TrainingNotFoundException extends RuntimeException {
    public TrainingNotFoundException(String message) {
        super(message);
    }
    public TrainingNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

}
