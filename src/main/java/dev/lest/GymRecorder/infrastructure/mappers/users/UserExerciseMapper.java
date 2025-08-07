package dev.lest.GymRecorder.infrastructure.mappers.users;

import dev.lest.GymRecorder.core.entities.Users.User;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserExerciseResponse;

public class UserExerciseMapper {

    public static UserExerciseResponse map(User user) {
        return UserExerciseResponse
                .builder()
                .id(user.getId())
                .build();
    }

}
