package dev.lest.GymRecorder.core.usecases.Users.classes;

import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Users.interfaces.FindByIdUserCase;

import java.util.Optional;

public class FindByIdUserCaseImp implements FindByIdUserCase {

    private final UserGateway userGateway;

    public FindByIdUserCaseImp(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public User execute(Long id) {
       return userGateway.findUserById(id).
               orElseThrow(() -> new RuntimeException("User not found!")); //TODO: Criar Exception especifica.
    }
}
