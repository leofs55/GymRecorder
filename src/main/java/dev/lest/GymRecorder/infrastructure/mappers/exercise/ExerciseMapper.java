package dev.lest.GymRecorder.infrastructure.mappers.exercise;

import dev.lest.GymRecorder.core.entities.Exercise.Exercise;
import dev.lest.GymRecorder.infrastructure.dtos.responses.exercise.ExerciseResponse;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserExerciseMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ExerciseMapper {

    public static ExerciseResponse map(Exercise exercise) {
        return ExerciseResponse.builder()
                .name(exercise.getName())
                .repetitions(exercise.getRepetitions())
                .sets(exercise.getSets())
                .weight(exercise.getWeight())
                .restTime(exercise.getRestTime())
                .trainingId(exercise.getTrainingId())
                .userResponse(UserExerciseMapper.map(exercise.getUser()))
                .build();
    }

}
