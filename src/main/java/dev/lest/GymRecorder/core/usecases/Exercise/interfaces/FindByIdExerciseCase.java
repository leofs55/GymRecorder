package dev.lest.GymRecorder.core.usecases.Exercise.interfaces;

import dev.lest.GymRecorder.core.entities.Exercise.Exercise;

public interface FindByIdExerciseCase {

    Exercise execute(String id);

}
