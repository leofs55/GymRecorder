package dev.lest.GymRecorder.core.usecases.Users.interfaces;

public interface DeleteUserCase {

    Boolean execute(Long id, String password);

}
