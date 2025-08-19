package dev.lest.GymRecorder.core.usecases.Exercise.classes;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.interfaces.FindAllByTrainingIdExerciseCase;

import java.util.List;

public class FindAllByTrainingIdExerciseCaseImp implements FindAllByTrainingIdExerciseCase {

    private final ExerciseGateway exerciseGateway;

    public FindAllByTrainingIdExerciseCaseImp(ExerciseGateway exerciseGateway) {
        this.exerciseGateway = exerciseGateway;
    }


    @Override
    public List<Exercise> execute(String trainingId) {
        return List.of();
    }
}
