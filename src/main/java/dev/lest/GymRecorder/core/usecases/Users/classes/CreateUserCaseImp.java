package dev.lest.GymRecorder.core.usecases.Users.classes;

import dev.lest.GymRecorder.core.entities.Exercise.Exercise;
import dev.lest.GymRecorder.core.entities.Users.User;
import dev.lest.GymRecorder.core.usecases.Users.interfaces.CreateUserCase;

public class CreateUserCaseImp implements CreateUserCase {


    @Override
    public User execute(User user) {
        return new User(
                user.id(),
                user.name(),
                user.email(),
                user.password());
    }
}
