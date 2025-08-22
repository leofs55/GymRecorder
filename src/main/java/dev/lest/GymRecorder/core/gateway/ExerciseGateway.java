package dev.lest.GymRecorder.core.gateway;

import dev.lest.GymRecorder.core.entities.Exercise;

import java.util.List;
import java.util.Optional;

public interface ExerciseGateway {

    Exercise createExercise(Exercise training);
    Exercise updateExercise(Exercise training);
    void deleteExercise(String id);
    Optional<Exercise> findExerciseById(String id);
    List<Exercise> findAllExerciseByUserId(Long id);
    List<Exercise> findAllExerciseByListId(List<String> idList);
    Boolean existsById(String id);

}
