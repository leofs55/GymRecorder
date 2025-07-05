package dev.lest.GymRecorder.core.entities.Users;

import dev.lest.GymRecorder.core.enuns.Role;

public record User(Long id,
                   String name,
                   String email,
                   String password,
                   Role userRole) {
}
