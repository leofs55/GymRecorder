package dev.lest.GymRecorder.infrastructure.mappers.training;

import dev.lest.GymRecorder.core.entities.Users.User;
import dev.lest.GymRecorder.infrastructure.dtos.responses.training.TrainingDeleteResponse;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TrainingDeleteMapper {

    public static TrainingDeleteResponse map(Boolean value,
                                             String id,
                                             User user) {
        if (value) {
            return TrainingDeleteResponse.builder()
                    .id(id)
                    .result("Deleted!")
                    .userResponse(UserMapper.map(user))
                    .build();
        }
        return TrainingDeleteResponse.builder()
                .id(id)
                .result("Not deleted!")
                .userResponse(UserMapper.map(user))
                .build();
    }
}
