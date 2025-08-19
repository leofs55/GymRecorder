package dev.lest.GymRecorder.infrastructure.mappers.training;

import dev.lest.GymRecorder.core.entities.Training;
import dev.lest.GymRecorder.infrastructure.dtos.responses.exercise.ExerciseResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.training.TrainingResponse;
import dev.lest.GymRecorder.infrastructure.mappers.exercise.ExerciseMapper;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserMapper;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class TrainingMapper {

    public static TrainingResponse map(Training training) {

        List<ExerciseResponse> exerciseList = training.getExercises().stream()
                .map(ExerciseMapper::map)
                .collect(Collectors.toList());

        return TrainingResponse.builder()
                .id(training.getId())
                .name(training.getName())
                .dayWeek(training.getDayWeek())
                .exerciseResponseList(exerciseList)
                .duration(training.getDuration())
                .userResponse(UserMapper.map(training.getUser()))
                .build();
    }


}
