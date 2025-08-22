package dev.lest.GymRecorder.core.usecases.Users.classes;

import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Users.interfaces.CreateUserCase;
import dev.lest.GymRecorder.infrastructure.exception.User.UserEmailAlreayExistException;

public class CreateUserCaseImp implements CreateUserCase {

    private final UserGateway userGateway;

    public CreateUserCaseImp(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        try {
            if (userGateway.existsByEmail(user.getEmail())) {
                throw new UserEmailAlreayExistException("User Error: User creation failed! The email ia already exist!");
            }
            return userGateway.createUser(user); //TODO: Criar Exception especifica.
        } catch (UserEmailAlreayExistException e) {
            throw new UserEmailAlreayExistException(e.getLocalizedMessage(), e);

        } catch (RuntimeException e) {
            throw new RuntimeException("User Error: Something in Creation User failed!",e);
        }
    }
}
