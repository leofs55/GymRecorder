package dev.lest.GymRecorder.infrastructure.mappers.users;

import dev.lest.GymRecorder.core.entities.Users.User;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserResponse;
import dev.lest.GymRecorder.infrastructure.persistence.entitys.Users;

public class UserMapper {

    public static UserResponse map(User user) {
        return UserResponse
                .builder()
                .name(users.getName())
                .email(users.getEmail())
                .userRole(users.getUserRole())
                .build();
    }
}
