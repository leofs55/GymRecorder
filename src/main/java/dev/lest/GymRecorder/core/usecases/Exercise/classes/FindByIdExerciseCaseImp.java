package dev.lest.GymRecorder.core.usecases.Exercise.classes;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.interfaces.FindByIdExerciseCase;

public class FindByIdExerciseCaseImp implements FindByIdExerciseCase {

    private final ExerciseGateway exerciseGateway;

    public FindByIdExerciseCaseImp(ExerciseGateway exerciseGateway) {
        this.exerciseGateway = exerciseGateway;
    }

    @Override
    public Exercise execute(String id) {
        return null;
    }
}
