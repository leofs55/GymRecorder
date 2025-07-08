package dev.lest.GymRecorder.infrastructure.dtos.responses.exercise;

import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserResponse;
import lombok.Builder;

@Builder
public record ExerciseDeleteResponse(String name,
                                     UserResponse userResponse) {
}
