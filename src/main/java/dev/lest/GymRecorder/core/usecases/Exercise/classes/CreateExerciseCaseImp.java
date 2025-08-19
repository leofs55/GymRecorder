package dev.lest.GymRecorder.core.usecases.Exercise.classes;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.interfaces.CreateExerciseCase;

public class CreateExerciseCaseImp implements CreateExerciseCase {

    private final ExerciseGateway exerciseGateway;

    public CreateExerciseCaseImp(ExerciseGateway exerciseGateway) {
        this.exerciseGateway = exerciseGateway;
    }

    @Override
    public Exercise execute(Exercise exercise) {
        return null;
    }

}