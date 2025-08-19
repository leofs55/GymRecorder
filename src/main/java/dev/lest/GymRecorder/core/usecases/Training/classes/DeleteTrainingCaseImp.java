package dev.lest.GymRecorder.core.usecases.Training.classes;

import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.core.usecases.Training.interfaces.DeleteTrainingCase;

public class DeleteTrainingCaseImp implements DeleteTrainingCase {

    private final TrainingGateway trainingGateway;

    public DeleteTrainingCaseImp(TrainingGateway trainingGateway) {
        this.trainingGateway = trainingGateway;
    }

    @Override
    public boolean execute(String id) {
        return false;
    }
}
