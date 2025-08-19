package dev.lest.GymRecorder.core.usecases.Exercise.classes;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.interfaces.UpdateExerciseCase;

public class UpdateExerciseCaseImp implements UpdateExerciseCase {

    private final ExerciseGateway exerciseGateway;

    public UpdateExerciseCaseImp(ExerciseGateway exerciseGateway) {
        this.exerciseGateway = exerciseGateway;
    }

    @Override
    public Exercise execute(Exercise training) {
        return null;
    }
}
