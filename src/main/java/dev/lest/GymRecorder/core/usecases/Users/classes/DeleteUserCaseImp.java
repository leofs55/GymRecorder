package dev.lest.GymRecorder.core.usecases.Users.classes;

import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Users.interfaces.DeleteUserCase;
import dev.lest.GymRecorder.core.usecases.Users.interfaces.FindByIdUserCase;

public class DeleteUserCaseImp implements DeleteUserCase {

    private final UserGateway userGateway;

    public DeleteUserCaseImp(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public Boolean execute(Long id, String password) {
        try {
            User userToDelete = userGateway.findUserById(id)
                    .orElseThrow( () -> new RuntimeException("User search for editing failed, user does not exist!"));

            if (!userToDelete.getPassword().equals(password)) {
                throw new RuntimeException("User deletion failed! Incorrect password!");
            }

            userGateway.deleteUser(id); //TODO: Criar Exception especifica.
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
