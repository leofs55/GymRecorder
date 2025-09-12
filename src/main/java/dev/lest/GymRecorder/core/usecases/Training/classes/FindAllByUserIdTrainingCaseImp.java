package dev.lest.GymRecorder.core.usecases.Training.classes;

import dev.lest.GymRecorder.core.entities.Training;
import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Training.interfaces.FindAllByUserIdTrainingCase;
import dev.lest.GymRecorder.infrastructure.exception.User.UserNotFoundException;

import java.util.List;

public class FindAllByUserIdTrainingCaseImp implements FindAllByUserIdTrainingCase {

    private final TrainingGateway trainingGateway;
    private final UserGateway userGateway;

    public FindAllByUserIdTrainingCaseImp(TrainingGateway trainingGateway, UserGateway userGateway) {
        this.trainingGateway = trainingGateway;
        this.userGateway = userGateway;
    }

    @Override
    public List<Training> execute(Long userId) {
        try {
            if (!userGateway.existsById(userId)) {
                throw new UserNotFoundException("Training Error: User not found for find all!");
            }
            return trainingGateway.findAllTrainingByUserId(userId);

        } catch (UserNotFoundException e) {
            throw new UserNotFoundException(e.getLocalizedMessage(), e);

        } catch (RuntimeException e) {
            throw new RuntimeException("Training Error: Something in Find all by user id failed!", e);
        }
    }
}
