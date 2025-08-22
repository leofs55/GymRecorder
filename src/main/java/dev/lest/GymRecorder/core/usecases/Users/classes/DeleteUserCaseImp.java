package dev.lest.GymRecorder.core.usecases.Users.classes;

import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Users.interfaces.DeleteUserCase;
import dev.lest.GymRecorder.core.usecases.Users.interfaces.FindByIdUserCase;
import dev.lest.GymRecorder.infrastructure.exception.User.PasswordDontMatchDeleteException;
import dev.lest.GymRecorder.infrastructure.exception.User.UserNotFoundException;

public class DeleteUserCaseImp implements DeleteUserCase {

    private final UserGateway userGateway;

    public DeleteUserCaseImp(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public Boolean execute(Long id, String password) {
        try {
            User userToDelete = userGateway.findUserById(id)
                    .orElseThrow(() -> new UserNotFoundException("User Erro: User search for editing failed, user does not exist!"));

            if (!userToDelete.getPassword().equals(password)) {
                throw new PasswordDontMatchDeleteException("User Erro: User deletion failed! Incorrect password!");
            }

            userGateway.deleteUser(id); //TODO: Criar Exception especifica.
            return true;
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException(e.getLocalizedMessage(), e);

        } catch (PasswordDontMatchDeleteException e) {
            throw new PasswordDontMatchDeleteException(e.getLocalizedMessage(), e);

        } catch (Exception e) {
            throw new RuntimeException("User Error: Something in User Delete failed!",e);
        }
    }
}
