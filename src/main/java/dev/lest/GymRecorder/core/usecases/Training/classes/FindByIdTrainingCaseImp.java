package dev.lest.GymRecorder.core.usecases.Training.classes;

import dev.lest.GymRecorder.core.entities.Training;
import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.core.usecases.Training.interfaces.FindByIdTrainingCase;

public class FindByIdTrainingCaseImp implements FindByIdTrainingCase {

    private final TrainingGateway trainingGateway;

    public FindByIdTrainingCaseImp(TrainingGateway trainingGateway) {
        this.trainingGateway = trainingGateway;
    }

    @Override
    public Training execute(String id) {
        return null;
    }
}
