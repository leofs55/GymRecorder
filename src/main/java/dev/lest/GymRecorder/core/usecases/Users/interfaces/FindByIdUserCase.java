package dev.lest.GymRecorder.core.usecases.Users.interfaces;

import dev.lest.GymRecorder.core.entities.Training.Training;
import dev.lest.GymRecorder.core.entities.Users.User;

public interface FindByIdUserCase {

    User execute(Long id);
}
