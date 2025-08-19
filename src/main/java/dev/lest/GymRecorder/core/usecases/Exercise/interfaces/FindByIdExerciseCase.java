package dev.lest.GymRecorder.core.usecases.Exercise.interfaces;

import dev.lest.GymRecorder.core.entities.Exercise;

public interface FindByIdExerciseCase {

    Exercise execute(String id);

}
