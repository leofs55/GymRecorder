package dev.lest.GymRecorder.core.usecases.Exercise.classes;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.interfaces.FindAllByUserIdExerciseCase;

import java.util.List;

public class FindAllByUserIdExerciseCaseImp implements FindAllByUserIdExerciseCase {

    private final ExerciseGateway exerciseGateway;

    public FindAllByUserIdExerciseCaseImp(ExerciseGateway exerciseGateway) {
        this.exerciseGateway = exerciseGateway;
    }

    @Override
    public List<Exercise> execute(Long userId) {
        try {
            return exerciseGateway.findAllExerciseByUserId(userId);
        } catch (RuntimeException e) {
            throw new RuntimeException("Exercise Error: Something for find all Exercise Failed by userId!", e);
        }
    }
}
