package dev.lest.GymRecorder.core.entities.Exercise;

import dev.lest.GymRecorder.core.entities.Users.User;

import java.time.Duration;

public record Exercise(String id,
                       String name,
                       Integer repetitions,
                       Integer sets,
                       Double weight,
                       Duration restTime,
                       String trainingId,
                       User user) {
}
