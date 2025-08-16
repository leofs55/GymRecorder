package dev.lest.GymRecorder.core.usecases.Users.classes;

import dev.lest.GymRecorder.core.usecases.Users.interfaces.DeleteUserCase;

public class DeleteUserCaseImp implements DeleteUserCase {

    @Override
    public boolean execute(Long id, String password) {
        return false;
    }
}
