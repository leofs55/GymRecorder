package dev.lest.GymRecorder.core.usecases.Training.classes;

import dev.lest.GymRecorder.core.entities.Training;
import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.core.usecases.Training.interfaces.FindAllByUserIdTrainingCase;

import java.util.List;

public class FindAllByUserIdTrainingCaseImp implements FindAllByUserIdTrainingCase {

    private final TrainingGateway trainingGateway;

    public FindAllByUserIdTrainingCaseImp(TrainingGateway trainingGateway) {
        this.trainingGateway = trainingGateway;
    }

    @Override
    public List<Training> execute(Long userId) {
        return trainingGateway.findAllTrainingByUserId(userId);
    }
}
