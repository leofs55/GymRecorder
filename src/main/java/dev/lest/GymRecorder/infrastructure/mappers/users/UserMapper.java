package dev.lest.GymRecorder.infrastructure.mappers.users;

import dev.lest.GymRecorder.core.entities.Users.User;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserExerciseResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static UserResponse map(User user) {
        return UserResponse
                .builder()
                .name(user.getName())
                .email(user.getEmail())
                .userRole(user.getUserRole())
                .build();
    }

}
