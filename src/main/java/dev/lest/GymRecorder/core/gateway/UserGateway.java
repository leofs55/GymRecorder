package dev.lest.GymRecorder.core.gateway;

import dev.lest.GymRecorder.core.entities.Users.User;

import java.util.Optional;

public interface UserGateway {

    User createUser(User user);
    Optional<User> findUserById(Long userId);
    Boolean deleteUser(Long id, String password);
    User updateUser(User user);

}
