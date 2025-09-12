package dev.lest.GymRecorder.core.usecases.Training.interfaces;

import dev.lest.GymRecorder.core.entities.Training;

public interface FindByIdTrainingCase {

    Training execute(String id);
}
