package dev.lest.GymRecorder.core.usecases.Users.interfaces;

import dev.lest.GymRecorder.core.entities.User;

public interface UpdateUserCase {

    User execute(User user);

}
