package dev.lest.GymRecorder.core.usecases.Training.interfaces;

import dev.lest.GymRecorder.core.entities.Training.Training;

public interface CreateTrainingCase {

    public Training execute(Training training);
}
