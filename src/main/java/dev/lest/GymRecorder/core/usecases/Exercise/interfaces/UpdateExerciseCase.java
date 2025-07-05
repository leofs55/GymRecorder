package dev.lest.GymRecorder.core.usecases.Exercise.interfaces;

import dev.lest.GymRecorder.core.entities.Exercise.Exercise;
import dev.lest.GymRecorder.core.entities.Training.Training;

public interface UpdateExerciseCase {

    Exercise execute(Exercise training);

}
