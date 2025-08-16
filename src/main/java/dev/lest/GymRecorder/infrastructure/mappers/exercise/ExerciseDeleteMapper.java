package dev.lest.GymRecorder.infrastructure.mappers.exercise;

import dev.lest.GymRecorder.core.entities.Users.User;
import dev.lest.GymRecorder.infrastructure.dtos.responses.exercise.ExerciseDeleteResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserResponse;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserExerciseMapper;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserMapper;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

@UtilityClass
public class ExerciseDeleteMapper {

    public static ExerciseDeleteResponse map(Boolean value,
                                             String id,
                                             User user) {
        if (value) {
            return ExerciseDeleteResponse.builder()
                    .id(id)
                    .result("Deleted!")
                    .userResponse(UserExerciseMapper.map(user))
                    .build();
        }
        return ExerciseDeleteResponse.builder()
                .id(id)
                .result("Not deleted!")
                .userResponse(UserExerciseMapper.map(user))
                .build();
    }
}
