package dev.lest.GymRecorder.infrastructure.mappers.exercise;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.infrastructure.dtos.requests.exercise.ExerciseCreateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.responses.exercise.ExerciseCreateResponse;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserCreateMapper;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserExerciseMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ExerciseCreateMapper {

    public static Exercise map(ExerciseCreateRequest exerciseCreateRequest) {
        return new Exercise(
                exerciseCreateRequest.name(),
                exerciseCreateRequest.repetitions(),
                exerciseCreateRequest.sets(),
                exerciseCreateRequest.weight(),
                exerciseCreateRequest.restTime(),
                UserCreateMapper.map(exerciseCreateRequest.userId())
        );
    }

    public static ExerciseCreateResponse map(Exercise exercise) {
        return ExerciseCreateResponse.builder()
                .id(exercise.getId())
                .name(exercise.getName())
                .repetitions(exercise.getRepetitions())
                .sets(exercise.getSets())
                .weight(exercise.getWeight())
                .restTime(exercise.getRestTime())
                .userResponse(UserExerciseMapper.map(exercise.getUser()))
                .build();
    }


}
