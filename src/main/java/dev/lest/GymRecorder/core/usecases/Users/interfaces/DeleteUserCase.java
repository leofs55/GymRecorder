package dev.lest.GymRecorder.core.usecases.Users.interfaces;

public interface DeleteUserCase {

    boolean execute(Long id, String password);

}
