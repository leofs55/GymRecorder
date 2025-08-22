package dev.lest.GymRecorder.infrastructure.dtos.responses.exercise;

import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserExerciseResponse;
import lombok.Builder;

import java.time.Duration;

@Builder
public record ExerciseResponse(String id,
                               String name,
                               Integer repetitions,
                               Integer sets,
                               Double weight,
                               Duration restTime,
                               UserExerciseResponse userResponse) {
}
