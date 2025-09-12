package dev.lest.GymRecorder.core.usecases.Exercise.classes;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.interfaces.FindAllByUserIdExerciseCase;
import dev.lest.GymRecorder.infrastructure.exception.User.UserNotFoundException;

import java.util.List;

public class FindAllByUserIdExerciseCaseImp implements FindAllByUserIdExerciseCase {

    private final ExerciseGateway exerciseGateway;
    private final UserGateway userGateway;

    public FindAllByUserIdExerciseCaseImp(ExerciseGateway exerciseGateway, UserGateway userGateway) {
        this.exerciseGateway = exerciseGateway;
        this.userGateway = userGateway;
    }

    @Override
    public List<Exercise> execute(Long userId) {
        try {
            if (!userGateway.existsById(userId)) {
                throw new UserNotFoundException("Exercise Error: User not found!");
            }
            return exerciseGateway.findAllExerciseByUserId(userId);

        } catch (UserNotFoundException e) {
            throw new UserNotFoundException(e.getLocalizedMessage(), e);

        } catch (RuntimeException e) {
            throw new RuntimeException("Exercise Error: Something for find all Exercise Failed by userId!", e);
        }
    }
}
