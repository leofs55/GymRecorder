package dev.lest.GymRecorder.infrastructure.mappers.users;

import dev.lest.GymRecorder.core.entities.Users.User;
import dev.lest.GymRecorder.infrastructure.persistence.entitys.UsersEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserGatewayMapper {

    public static User map(UsersEntity usersEntity) {
        return new User(
                usersEntity.getId(),
                usersEntity.getName(),
                usersEntity.getEmail(),
                usersEntity.getPassword(),
                usersEntity.getUserRole()
        );
    }

    public static UsersEntity map(User user) {
        return UsersEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .userRole(user.getUserRole())
                .build();
    }
}
