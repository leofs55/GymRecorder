package dev.lest.GymRecorder.infrastructure.mappers.training;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.entities.Training;
import dev.lest.GymRecorder.infrastructure.dtos.requests.training.TrainingUpdateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.responses.exercise.ExerciseUpdateResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.training.TrainingUpdateResponse;
import dev.lest.GymRecorder.infrastructure.mappers.exercise.ExerciseUpdateMapper;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserUpdateMapper;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class TrainingUpdateMapper {

    public static Training map(TrainingUpdateRequest trainingUpdateRequest) {

        List<Exercise> exerciseList = trainingUpdateRequest.exerciseResponseList().stream()
                .map(ExerciseUpdateMapper::map)
                .collect(Collectors.toList());

        return new Training(
                trainingUpdateRequest.name(),
                trainingUpdateRequest.dayWeek(),
                exerciseList,
                trainingUpdateRequest.duration(),
                UserUpdateMapper.map(trainingUpdateRequest.userId())
        );
    }

    public static Training map(String id) {
        return new Training(id);
    }

    public static TrainingUpdateResponse map(Training training) {

        List<ExerciseUpdateResponse> responseList = training.getExercises().stream()
                .map(ExerciseUpdateMapper::map)
                .collect(Collectors.toList());

        return TrainingUpdateResponse.builder()
                .id(training.getId())
                .name(training.getName())
                .dayWeek(training.getDayWeek())
                .exerciseResponseList(responseList)
                .userResponse(UserUpdateMapper.map(training.getUser()))
                .build();
    }
}
