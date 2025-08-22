package dev.lest.GymRecorder.core.usecases.Users.interfaces;

import dev.lest.GymRecorder.core.entities.User;

import java.util.Optional;

public interface FindByIdUserCase {

    User execute(Long id);
}
