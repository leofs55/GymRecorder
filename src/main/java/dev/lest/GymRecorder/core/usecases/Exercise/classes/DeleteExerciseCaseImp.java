package dev.lest.GymRecorder.core.usecases.Exercise.classes;

import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.interfaces.DeleteExerciseCase;
import dev.lest.GymRecorder.infrastructure.exception.Exercise.UserNotFoundInExerciseDeleteException;

public class DeleteExerciseCaseImp implements DeleteExerciseCase {

    private final ExerciseGateway exerciseGateway;

    public DeleteExerciseCaseImp(ExerciseGateway exerciseGateway) {
        this.exerciseGateway = exerciseGateway;
    }

    @Override
    public boolean execute(String id) {
        try {
            if (!exerciseGateway.existsById(id)) {
                throw new UserNotFoundInExerciseDeleteException("Exercise Error: Exercise search for delete failed, exercise does not exist!");
            }
            exerciseGateway.deleteExercise(id);
            return true;
        } catch (UserNotFoundInExerciseDeleteException e) {
            throw new UserNotFoundInExerciseDeleteException(e.getLocalizedMessage(), e);
        } catch (RuntimeException e) {
            throw new RuntimeException("Exercise Error: Something in Delete Exercise Failed!",e);
        }
    }
}
