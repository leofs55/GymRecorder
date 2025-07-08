package dev.lest.GymRecorder.infrastructure.dtos.responses.exercise;

import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserResponse;
import lombok.Builder;

import java.time.Duration;

@Builder
public record ExerciseResponse(String name,
                               Integer repetitions,
                               Integer sets,
                               Double weight,
                               Duration restTime,
                               Long trainingId,
                               UserResponse userResponse) {
}
