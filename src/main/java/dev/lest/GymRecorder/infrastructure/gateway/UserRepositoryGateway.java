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
        log.info(user.toString());
        UsersEntity usersToEntity = UserGatewayMapper.map(user);
        UsersEntity savedUsersEntity = repository.save(usersToEntity);
        return UserGatewayMapper.map(savedUsersEntity);
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        Optional<UsersEntity> findedUsersEntity = repository.findById(userId);
        return findedUsersEntity.map(UserGatewayMapper::map);
    }

    @Override
    public Boolean deleteUser(Long id, String password) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        UsersEntity usersToEntity = UserGatewayMapper.map(user);
        UsersEntity savedUsersEntity = repository.save(usersToEntity);
        return UserGatewayMapper.map(savedUsersEntity);
    }
}

