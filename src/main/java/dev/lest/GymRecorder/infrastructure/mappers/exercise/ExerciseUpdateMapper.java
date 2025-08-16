package dev.lest.GymRecorder.infrastructure.mappers.exercise;

import dev.lest.GymRecorder.core.entities.Exercise.Exercise;
import dev.lest.GymRecorder.infrastructure.dtos.requests.exercise.ExerciseUpdateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.responses.exercise.ExerciseUpdateResponse;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserExerciseMapper;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserUpdateMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ExerciseUpdateMapper {

    public static Exercise map(ExerciseUpdateRequest exerciseUpdateRequest) {
        return new Exercise(
                exerciseUpdateRequest.name(),
                exerciseUpdateRequest.repetitions(),
                exerciseUpdateRequest.sets(),
                exerciseUpdateRequest.weight(),
                exerciseUpdateRequest.restTime(),
                exerciseUpdateRequest.trainingId(),
                UserUpdateMapper.map(exerciseUpdateRequest.userId())
        );
    }

    public static ExerciseUpdateResponse map(Exercise exercise) {
        return ExerciseUpdateResponse.builder()
                .id(exercise.getId())
                .name(exercise.getName())
                .repetitions(exercise.getRepetitions())
                .sets(exercise.getSets())
                .weight(exercise.getWeight())
                .restTime(exercise.getRestTime())
                .traininId(exercise.getTrainingId())
                .userResponse(UserExerciseMapper.map(exercise.getUser()))
                .build();
    }
}
