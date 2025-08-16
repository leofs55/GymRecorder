package dev.lest.GymRecorder.infrastructure.gateway;

import dev.lest.GymRecorder.core.entities.Users.User;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserGatewayMapper;
import dev.lest.GymRecorder.infrastructure.persistence.interfaces.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryGateway implements UserGateway {

    private final UserRepository repository;

    @Override
    public User createUser(User user) {
        return UserGatewayMapper.map(repository.save(UserGatewayMapper.map(user)));
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        return null;
    }

    @Override
    public User deleteUser(Long id, String password) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}

