package dev.lest.GymRecorder.infrastructure.dtos.requests.user;

import dev.lest.GymRecorder.core.enuns.Role;
import lombok.Builder;

@Builder
public record UserCreateRequest(String name,
                                String email,
                                String password,
                                Role userRole) {
}
