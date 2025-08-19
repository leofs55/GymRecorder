package dev.lest.GymRecorder.core.usecases.Exercise.classes;

import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.interfaces.DeleteExerciseCase;

public class DeleteExerciseCaseImp implements DeleteExerciseCase {

    private final ExerciseGateway exerciseGateway;

    public DeleteExerciseCaseImp(ExerciseGateway exerciseGateway) {
        this.exerciseGateway = exerciseGateway;
    }

    @Override
    public boolean execute(String id) {
        return false;
    }
}
