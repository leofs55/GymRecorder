package dev.lest.GymRecorder.core.usecases.Training.interfaces;

import dev.lest.GymRecorder.core.entities.Training.Training;

public interface DeleteTrainingCase {

    void execute(Long id);

}
