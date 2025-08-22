package dev.lest.GymRecorder.infrastructure.dtos.requests.exercise;

import java.time.Duration;

public record ExerciseUpdateRequest(String name,
                                    Integer repetitions,
                                    Integer sets,
                                    Double weight,
                                    Duration restTime,
                                    Long userId) {
}
