package dev.lest.GymRecorder.core.usecases.Training.classes;

import dev.lest.GymRecorder.core.entities.Training.Training;
import dev.lest.GymRecorder.core.usecases.Training.interfaces.CreateTrainingCase;

public class CreateTrainingCaseImp implements CreateTrainingCase {

    @Override
    public Training execute(Training training) {
        return new Training(
                training.id(),
                training.name(),
                training.dayWeek(),
                training.exercises(),
                training.duration());
    }

}
