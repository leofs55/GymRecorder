package dev.lest.GymRecorder.infrastructure.dtos.responses.user;

import dev.lest.GymRecorder.core.enuns.Role;
import lombok.Builder;

@Builder
public record UserResponse(Long id,
                           String name,
                           String email,
                           Role userRole) {
}
