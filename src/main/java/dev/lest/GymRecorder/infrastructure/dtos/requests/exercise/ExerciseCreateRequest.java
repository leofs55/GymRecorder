package dev.lest.GymRecorder.infrastructure.dtos.requests.exercise;

import lombok.Builder;

import java.time.Duration;

@Builder
public record ExerciseCreateRequest(String name,
                                    Integer repetitions,
                                    Integer sets,
                                    Double weight,
                                    Duration restTime,
                                    Long userId) {
}
