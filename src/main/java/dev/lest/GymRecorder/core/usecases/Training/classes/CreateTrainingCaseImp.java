package dev.lest.GymRecorder.core.usecases.Training.classes;

import dev.lest.GymRecorder.core.entities.Training;
import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.core.usecases.Training.interfaces.CreateTrainingCase;

public class CreateTrainingCaseImp implements CreateTrainingCase {

    private final TrainingGateway trainingGateway;

    public CreateTrainingCaseImp(TrainingGateway trainingGateway) {
        this.trainingGateway = trainingGateway;
    }

    @Override
    public Training execute(Training training) {
        return null;
    }
}
