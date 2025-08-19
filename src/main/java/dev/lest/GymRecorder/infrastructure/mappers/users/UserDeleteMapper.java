package dev.lest.GymRecorder.infrastructure.mappers.users;

import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.infrastructure.dtos.requests.user.UserDeleteRequest;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserDeleteResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserDeleteMapper {

    public static User map(UserDeleteRequest userDeleteRequest) {
        return new User(
                userDeleteRequest.email(),
                userDeleteRequest.password()
        );
    }

    public static UserDeleteResponse map(Boolean result, Long id) {

        if (result) {
            return UserDeleteResponse
                    .builder()
                    .id(id)
                    .result("Deleted!")
                    .build();
        }
        return UserDeleteResponse
                .builder()
                .id(id)
                .result("Not Deleted!")
                .build();
    }
}
