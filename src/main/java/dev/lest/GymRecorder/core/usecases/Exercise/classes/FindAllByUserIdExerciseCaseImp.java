package dev.lest.GymRecorder.core.usecases.Exercise.classes;

import dev.lest.GymRecorder.core.entities.Exercise.Exercise;
import dev.lest.GymRecorder.core.entities.Training.Training;
import dev.lest.GymRecorder.core.usecases.Exercise.interfaces.FindAllByUserIdExerciseCase;
import dev.lest.GymRecorder.core.usecases.Training.interfaces.FindAllByUserIdTrainingCase;

import java.util.List;

public class FindAllByUserIdExerciseCaseImp implements FindAllByUserIdExerciseCase {

    @Override
    public List<Exercise> execute(Long userId) {
        return List.of();
    }
}
