package dev.lest.GymRecorder.core.usecases.Exercise.interfaces;

import dev.lest.GymRecorder.core.entities.Exercise.Exercise;

import java.util.List;

public interface FindAllByTrainingIdExerciseCase {

    List<Exercise> execute(String trainingId);

}
