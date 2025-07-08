package dev.lest.GymRecorder.infrastructure.mappers.users;

import dev.lest.GymRecorder.core.entities.Users.User;
import dev.lest.GymRecorder.infrastructure.dtos.requests.user.UserDeleteRequest;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserDeleteResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserResponse;
import dev.lest.GymRecorder.infrastructure.persistence.entitys.Users;
import org.springframework.stereotype.Component;

@Component
public class UserDeleteMapper {

    public static User map(UserDeleteRequest userDeleteRequest) {
        return User
                .builder()
                .email(userDeleteRequest.email())
                .password(userDeleteRequest.password())
                .build();
    }

    public static UserDeleteResponse map(Long id, String result) {
        return UserDeleteResponse
                .builder()
                .id(id)
                .result(result)
                .build();
    }
}
