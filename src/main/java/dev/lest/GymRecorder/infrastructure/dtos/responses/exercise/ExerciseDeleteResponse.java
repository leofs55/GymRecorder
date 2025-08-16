package dev.lest.GymRecorder.infrastructure.dtos.responses.exercise;

import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserExerciseResponse;
import lombok.Builder;

@Builder
public record ExerciseDeleteResponse(String id,
                                     String result,
                                     UserExerciseResponse userResponse) {
}
