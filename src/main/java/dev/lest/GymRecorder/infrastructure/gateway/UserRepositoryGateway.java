package dev.lest.GymRecorder.infrastructure.gateway;

import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserGatewayMapper;
import dev.lest.GymRecorder.infrastructure.persistence.entitys.UsersEntity;
import dev.lest.GymRecorder.infrastructure.persistence.interfaces.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryGateway implements UserGateway {

    private final UserRepository repository;

    @Override
    public User createUser(User user) {
        UsersEntity usersToEntity = UserGatewayMapper.map(user);
        UsersEntity savedUsersEntity = repository.save(usersToEntity);
        return UserGatewayMapper.map(savedUsersEntity);
    }

    @Override
    public User updateUser(User user) {
        UsersEntity usersToEntity = UserGatewayMapper.map(user);
        UsersEntity savedUsersEntity = repository.save(usersToEntity);
        return UserGatewayMapper.map(savedUsersEntity);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        Optional<UsersEntity> findedUsersEntity = repository.findById(userId);
        return findedUsersEntity.map(UserGatewayMapper::map);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}

