package dev.lest.GymRecorder.core.usecases.Users.interfaces;

import dev.lest.GymRecorder.core.entities.Exercise.Exercise;
import dev.lest.GymRecorder.core.entities.Users.User;

public interface CreateUserCase {

    public User execute(User user);
}
