package dev.lest.GymRecorder.core.usecases.Training.classes;

import dev.lest.GymRecorder.core.entities.Training;
import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.core.usecases.Training.interfaces.DeleteTrainingCase;
import dev.lest.GymRecorder.core.usecases.Users.classes.FindByIdUserCaseImp;
import dev.lest.GymRecorder.infrastructure.exception.Training.TrainingNotFoundException;

public class DeleteTrainingCaseImp implements DeleteTrainingCase {

    private final TrainingGateway trainingGateway;

    public DeleteTrainingCaseImp(TrainingGateway trainingGateway) {
        this.trainingGateway = trainingGateway;
    }

    @Override
    public Boolean execute(String id) {
        try {
            if (!trainingGateway.existsById(id)) {
                throw new TrainingNotFoundException("Training search for delete failed, Training does not exist!");
            }

            trainingGateway.deleteTraining(id);
            return true;

        } catch (TrainingNotFoundException e) {
            throw new TrainingNotFoundException(e.getLocalizedMessage(), e);

        } catch (RuntimeException e) {
            throw new RuntimeException("" ,e);
        }
    }
}
