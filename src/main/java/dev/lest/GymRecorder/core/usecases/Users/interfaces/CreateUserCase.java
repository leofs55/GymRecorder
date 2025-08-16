package dev.lest.GymRecorder.core.usecases.Users.interfaces;

import dev.lest.GymRecorder.core.entities.Users.User;

public interface CreateUserCase {

    User execute(User user);

}
