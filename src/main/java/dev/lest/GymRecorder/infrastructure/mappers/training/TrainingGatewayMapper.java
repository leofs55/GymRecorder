package dev.lest.GymRecorder.infrastructure.mappers.training;

import dev.lest.GymRecorder.core.entities.Exercise.Exercise;
import dev.lest.GymRecorder.core.entities.Training.Training;
import dev.lest.GymRecorder.infrastructure.mappers.exercise.ExerciseGatewayMapper;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserGatewayMapper;
import dev.lest.GymRecorder.infrastructure.persistence.entitys.ExerciseEntity;
import dev.lest.GymRecorder.infrastructure.persistence.entitys.TrainingEntity;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class TrainingGatewayMapper {

    public static Training map(TrainingEntity trainingEntity) {

        List<Exercise> exerciseEntityList = trainingEntity.getExercises().stream()
                .map(ExerciseGatewayMapper::map)
                .collect(Collectors.toList());

        return new Training(
                trainingEntity.getId(),
                trainingEntity.getName(),
                trainingEntity.getDayWeek(),
                exerciseEntityList,
                trainingEntity.getDuration(),
                UserGatewayMapper.map(trainingEntity.getUser())
        );
    }

    public static TrainingEntity map(Training training) {

        List<ExerciseEntity> exerciseEntityList = training.getExercises().stream()
                .map(ExerciseGatewayMapper::map)
                .collect(Collectors.toList());

        return TrainingEntity.builder()
                .id(training.getId())
                .name(training.getName())
                .dayWeek(training.getDayWeek())
                .exercises(exerciseEntityList)
                .duration(training.getDuration())
                .user(UserGatewayMapper.map(training.getUser()))
                .build();

    }
}
