package dev.lest.GymRecorder.infrastructure.mappers.users;

import dev.lest.GymRecorder.core.entities.Users.User;
import dev.lest.GymRecorder.infrastructure.dtos.requests.user.UserCreateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.requests.user.UserUpdateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserCreateResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserUpdateResponse;
import dev.lest.GymRecorder.infrastructure.persistence.entitys.Users;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateMapper {

    public static User map(UserUpdateRequest userUpdateRequest) {
        return User
                .builder()
                .name(userUpdateRequest.name())
                .email(userUpdateRequest.email())
                .password(userUpdateRequest.password())
                .userRole(userUpdateRequest.userRole())
                .build();
    }

    public static UserUpdateResponse map(User users) {
        return UserUpdateResponse
                .builder()
                .name(users.getName())
                .email(users.getEmail())
                .build();
    }
}
