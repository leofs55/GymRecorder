package dev.lest.GymRecorder.infrastructure.dtos.responses.user;

import dev.lest.GymRecorder.core.enuns.Role;
import lombok.Builder;

@Builder
public record UserUpdateResponse(String name,
                                 String email,
                                 Role userRole) {
}
