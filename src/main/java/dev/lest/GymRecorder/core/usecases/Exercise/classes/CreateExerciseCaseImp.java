package dev.lest.GymRecorder.core.usecases.Exercise.classes;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.interfaces.CreateExerciseCase;
import dev.lest.GymRecorder.infrastructure.exception.Exercise.UserNotFoundInExerciseCreationException;

public class CreateExerciseCaseImp implements CreateExerciseCase {

    private final ExerciseGateway exerciseGateway;
    private final UserGateway userGateway;

    public CreateExerciseCaseImp(ExerciseGateway exerciseGateway,
                                 UserGateway userGateway) {
        this.exerciseGateway = exerciseGateway;
        this.userGateway = userGateway;
    }

    @Override
    public Exercise execute(Exercise exercise) {
        try {
            // TODO: Reformular a entidade do core e da infra pq o vai dar conflito de criacao, um deles vai ter que ser criado antes
            if (!userGateway.existsById(exercise.getUser().getId())) {
                throw new UserNotFoundInExerciseCreationException("Exercise Error: User not found!");
            }
            return exerciseGateway.createExercise(exercise);
        } catch (UserNotFoundInExerciseCreationException e) {
            throw new UserNotFoundInExerciseCreationException(e.getLocalizedMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Exercise Error: Something in Creation Exercise Failed!" ,e);
        }

    }

}