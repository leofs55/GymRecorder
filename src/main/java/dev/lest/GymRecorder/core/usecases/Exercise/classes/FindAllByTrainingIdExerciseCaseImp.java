package dev.lest.GymRecorder.core.usecases.Exercise.classes;

import dev.lest.GymRecorder.core.entities.Exercise.Exercise;
import dev.lest.GymRecorder.core.usecases.Exercise.interfaces.FindAllByTrainingIdExerciseCase;

import java.util.List;

public class FindAllByTrainingIdExerciseCaseImp implements FindAllByTrainingIdExerciseCase {

    @Override
    public List<Exercise> execute(String trainingId) {
        return List.of();
    }
}
