package dev.lest.GymRecorder.infrastructure.mappers.users;

import dev.lest.GymRecorder.core.entities.Users.User;
import dev.lest.GymRecorder.infrastructure.dtos.requests.user.UserUpdateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserUpdateResponse;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateMapper {

    public static User map(UserUpdateRequest userUpdateRequest) {
        return new User(
                userUpdateRequest.name(),
                userUpdateRequest.email(),
                userUpdateRequest.password(),
                userUpdateRequest.userRole()
        );
    }

    public static User map(Long id) {
        return new User(id);
    }

    public static UserUpdateResponse map(User user) {
        return UserUpdateResponse
                .builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
