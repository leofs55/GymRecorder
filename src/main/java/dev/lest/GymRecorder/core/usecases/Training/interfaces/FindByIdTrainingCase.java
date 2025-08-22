package dev.lest.GymRecorder.core.usecases.Training.interfaces;

import dev.lest.GymRecorder.core.entities.Training;

import java.util.Optional;

public interface FindByIdTrainingCase {

    Training execute(String id);
}
