package dev.lest.GymRecorder.infrastructure.dtos.responses.training;

import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserResponse;
import lombok.Builder;

@Builder
public record TrainingDeleteResponse(String id,
                                     String name,
                                     UserResponse userResponse) {
}
