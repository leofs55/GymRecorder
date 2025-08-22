package dev.lest.GymRecorder.core.usecases.Training.classes;

import dev.lest.GymRecorder.core.entities.Training;
import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.core.usecases.Training.interfaces.FindByIdTrainingCase;
import dev.lest.GymRecorder.infrastructure.exception.Training.TrainingNotFoundException;

public class FindByIdTrainingCaseImp implements FindByIdTrainingCase {

    private final TrainingGateway trainingGateway;

    public FindByIdTrainingCaseImp(TrainingGateway trainingGateway) {
        this.trainingGateway = trainingGateway;
    }

    @Override
    public Training execute(String id) {
        try {
            return trainingGateway.findTrainingById(id)
                    .orElseThrow( () -> new TrainingNotFoundException("Training not exist")); //TODO: Criar Exception especifica.

        } catch (TrainingNotFoundException e) {
            throw new TrainingNotFoundException(e.getLocalizedMessage(), e);
        }
    }
}
