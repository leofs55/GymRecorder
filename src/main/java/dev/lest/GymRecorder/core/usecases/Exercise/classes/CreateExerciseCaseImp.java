package dev.lest.GymRecorder.core.usecases.Exercise.classes;

import dev.lest.GymRecorder.core.entities.Exercise.Exercise;
import dev.lest.GymRecorder.core.usecases.Exercise.interfaces.CreateExerciseCase;

public class CreateExerciseCaseImp implements CreateExerciseCase {

    @Override
    public Exercise execute(Exercise exercise) {
        return new Exercise(
                exercise.id(),
                exercise.name(),
                exercise.repetitions(),
                exercise.sets(),
                exercise.weight(),
                exercise.restTime(),
                exercise.idTraing(),
                exercise.idUser());
    }

}
