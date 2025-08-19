package dev.lest.GymRecorder.core.usecases.Users.classes;

import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Users.interfaces.UpdateUserCase;

public class UpdateUserCaseImp implements UpdateUserCase {

    private final UserGateway userGateway;

    public UpdateUserCaseImp(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(User user) {
        return null;
    }
}
