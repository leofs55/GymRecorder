package dev.lest.GymRecorder.infrastructure.mappers.users;

import dev.lest.GymRecorder.core.entities.Users.User;
import dev.lest.GymRecorder.infrastructure.dtos.requests.user.UserCreateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserCreateResponse;
import org.springframework.stereotype.Component;

@Component
public class UserCreateMapper {

    public static User map(UserCreateRequest userCreateRequest) {
        return new User(
                userCreateRequest.name(),
                userCreateRequest.email(),
                userCreateRequest.password(),
                userCreateRequest.userRole()
        );
    }

    public static User map(Long id) {
        return new User(id);
    }

    public static UserCreateResponse map(User user) {
        return UserCreateResponse
                .builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

}
