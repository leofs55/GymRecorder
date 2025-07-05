package dev.lest.GymRecorder.core.entities.Exercise;

import java.time.Duration;

public record Exercise(String id,
                       String name,
                       Integer repetitions,
                       Integer sets,
                       Double weight,
                       Duration restTime,
                       Long trainingId,
                       Long userId) {
}
