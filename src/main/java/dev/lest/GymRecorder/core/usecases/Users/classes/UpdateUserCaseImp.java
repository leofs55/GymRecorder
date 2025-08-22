package dev.lest.GymRecorder.core.usecases.Users.classes;

import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.core.enuns.Role;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Users.interfaces.UpdateUserCase;
import dev.lest.GymRecorder.infrastructure.exception.User.UserEmailAlreayExistException;
import dev.lest.GymRecorder.infrastructure.exception.User.UserNotFoundException;

public class UpdateUserCaseImp implements UpdateUserCase {

    private final UserGateway userGateway;

    public UpdateUserCaseImp(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        try {
            User userToUpdate = userGateway.findUserById(user.getId())
                    .orElseThrow(() -> new UserNotFoundException("User search for editing failed, user does not exist!"));

            String name = (user.getName() == null) ? userToUpdate.getName() : user.getName();
            String email = (user.getEmail() == null) ? userToUpdate.getEmail() : user.getEmail();
            String password = (user.getPassword() == null) ? userToUpdate.getPassword() : user.getPassword();
            Role userRole = (user.getUserRole() == null) ? userToUpdate.getUserRole() : user.getUserRole();

            if (userGateway.existsByEmail(email)) {
                throw new UserEmailAlreayExistException("User editing failed, email already exist!");
            }

            User newUser = new User(user.getId(), name, email, password, userRole);
            return userGateway.updateUser(newUser);

        } catch (UserNotFoundException e) {
            throw new UserNotFoundException(e.getLocalizedMessage(), e);

        } catch (UserEmailAlreayExistException e) {
            throw new UserEmailAlreayExistException(e.getLocalizedMessage(), e); //TODO: Criar Exception especifica.

        } catch (RuntimeException e) {
            throw new RuntimeException("User Error: Something in Updade User failed!", e);
        }
    }
}
