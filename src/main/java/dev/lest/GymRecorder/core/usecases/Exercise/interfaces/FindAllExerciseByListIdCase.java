package dev.lest.GymRecorder.core.usecases.Exercise.interfaces;

import dev.lest.GymRecorder.core.entities.Exercise;

import java.util.List;

public interface FindAllExerciseByListIdCase {

    List<Exercise> execute(List<Exercise> list);

}
