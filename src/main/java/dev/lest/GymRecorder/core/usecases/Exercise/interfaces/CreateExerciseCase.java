package dev.lest.GymRecorder.core.usecases.Exercise.interfaces;

import dev.lest.GymRecorder.core.entities.Exercise.Exercise;

public interface CreateExerciseCase {

    Exercise execute(Exercise exercise);

}
