package dev.lest.GymRecorder.infrastructure.dtos.requests.user;

import dev.lest.GymRecorder.core.enuns.Role;

public record UserUpdateRequest(String name,
                                String email,
                                String password,
                                Role userRole) {
}
