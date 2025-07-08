package dev.lest.GymRecorder.infrastructure.mappers.users;

import dev.lest.GymRecorder.core.entities.Users.User;
import dev.lest.GymRecorder.infrastructure.dtos.requests.user.UserCreateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserCreateResponse;
import dev.lest.GymRecorder.infrastructure.persistence.entitys.Users;
import org.springframework.stereotype.Component;

@Component
public class UserCreateMapper {

    public static User map(UserCreateRequest userCreateRequest) {
        return User
                .builder()
                .name(userCreateRequest.name())
                .email(userCreateRequest.email())
                .password(userCreateRequest.password())
                .userRole(userCreateRequest.userRole())
                .build();
    }

    public static UserCreateResponse map(User user) {
        return UserCreateResponse
                .builder()
                .name(users.getName())
                .email(users.getEmail())
                .build();
    }

}
