package dev.lest.GymRecorder.infrastructure.mappers.training;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.entities.Training;
import dev.lest.GymRecorder.infrastructure.dtos.requests.training.TrainingCreateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.responses.exercise.ExerciseResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.training.TrainingCreateResponse;
import dev.lest.GymRecorder.infrastructure.mappers.exercise.ExerciseCreateMapper;
import dev.lest.GymRecorder.infrastructure.mappers.exercise.ExerciseMapper;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserCreateMapper;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class TrainingCreateMapper {

    public static Training map(TrainingCreateRequest trainingCreateRequest) {

        List<Exercise> exerciseList = trainingCreateRequest.exerciseResponseList().stream()
                .map(ExerciseCreateMapper::map)
                .collect(Collectors.toList());

        return new Training(
                trainingCreateRequest.name(),
                trainingCreateRequest.dayWeek(),
                exerciseList,
                trainingCreateRequest.duration(),
                UserCreateMapper.map(trainingCreateRequest.userId())
        );
    }

    public static Training map(String id) {
        return new Training(id);
    }

    public static TrainingCreateResponse map(Training training) {

        List<ExerciseResponse> responseList = training.getExercises().stream()
                .map(ExerciseMapper::map)
                .collect(Collectors.toList());

        return TrainingCreateResponse.builder()
                .id(training.getId())
                .name(training.getName())
                .dayWeek(training.getDayWeek())
                .exerciseResponseList(responseList)
                .userResponse(UserCreateMapper.map(training.getUser()))
                .build();
    }

}