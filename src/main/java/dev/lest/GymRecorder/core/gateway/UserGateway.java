package dev.lest.GymRecorder.core.gateway;

import dev.lest.GymRecorder.core.entities.User;

import java.util.Optional;

public interface UserGateway {

    User createUser(User user);
    Optional<User> findUserById(Long userId);
    void deleteUser(Long id);
    User updateUser(User user);
    Boolean existsByEmail(String email);
    Boolean existsById(Long id);

}
