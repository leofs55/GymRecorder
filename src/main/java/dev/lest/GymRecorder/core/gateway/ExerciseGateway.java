package dev.lest.GymRecorder.core.gateway;

import dev.lest.GymRecorder.core.entities.Exercise.Exercise;
import dev.lest.GymRecorder.core.entities.Training.Training;

import java.util.List;
import java.util.Optional;

public interface ExerciseGateway {

    Exercise createExercise(Exercise training);
    Exercise updateExercise(Exercise training);
    Boolean deleteExercise(String id);
    Optional<Exercise> findExerciseById(String id);
    List<Exercise> findAllExerciseByTrainingId(Long id);
    List<Exercise> findAllExerciseByUserId(Long id);

}
