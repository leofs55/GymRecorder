package dev.lest.GymRecorder.infrastructure.mappers.exercise;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserGatewayMapper;
import dev.lest.GymRecorder.infrastructure.persistence.entitys.ExerciseEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ExerciseGatewayMapper {

    public static Exercise map(ExerciseEntity exerciseEntity) {
        return new Exercise(
                exerciseEntity.getId(),
                exerciseEntity.getName(),
                exerciseEntity.getRepetitions(),
                exerciseEntity.getSets(),
                exerciseEntity.getWeight(),
                exerciseEntity.getRestTime(),
                exerciseEntity.getTrainingId(),
                UserGatewayMapper.map(exerciseEntity.getUser())
        );
    }

    public static ExerciseEntity map(Exercise exercise) {
        return ExerciseEntity.builder()
                .id(exercise.getId())
                .name(exercise.getName())
                .repetitions(exercise.getRepetitions())
                .sets(exercise.getSets())
                .sets(exercise.getSets())
                .weight(exercise.getWeight())
                .restTime(exercise.getRestTime())
                .user(UserGatewayMapper.map(exercise.getUser()))
                .build();
    }
}
