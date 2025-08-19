package dev.lest.GymRecorder.core.usecases.Users.classes;

import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Users.interfaces.DeleteUserCase;

public class DeleteUserCaseImp implements DeleteUserCase {

    private final UserGateway userGateway;

    public DeleteUserCaseImp(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public boolean execute(Long id, String password) {
        return false;
    }
}
