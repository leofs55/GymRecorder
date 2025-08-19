package dev.lest.GymRecorder.core.usecases.Users.interfaces;

import dev.lest.GymRecorder.core.entities.User;

public interface CreateUserCase {

    User execute(User user);

}
