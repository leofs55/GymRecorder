package dev.lest.GymRecorder.infrastructure.presentation;

import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.core.usecases.Exercise.interfaces.*;
import dev.lest.GymRecorder.infrastructure.dtos.requests.exercise.ExerciseCreateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.requests.exercise.ExerciseUpdateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.responses.exercise.ExerciseCreateResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.exercise.ExerciseDeleteResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.exercise.ExerciseResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.exercise.ExerciseUpdateResponse;
import dev.lest.GymRecorder.infrastructure.mappers.exercise.ExerciseCreateMapper;
import dev.lest.GymRecorder.infrastructure.mappers.exercise.ExerciseDeleteMapper;
import dev.lest.GymRecorder.infrastructure.mappers.exercise.ExerciseMapper;
import dev.lest.GymRecorder.infrastructure.mappers.exercise.ExerciseUpdateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/exercise/")
@RequiredArgsConstructor
public class ExerciseController {

    private final CreateExerciseCase createExercise;
    private final DeleteExerciseCase deleteExercise;
    private final FindAllByTrainingIdExerciseCase findAllByTrainingIdExercise;
    private final FindAllByUserIdExerciseCase findAllByUserIdExercise;
    private final FindByIdExerciseCase findByIdExercise;
    private final UpdateExerciseCase updateExercise;

    @PostMapping("create")
    public ResponseEntity<ExerciseCreateResponse> createEndPoint(@RequestBody ExerciseCreateRequest exerciseCreateRequest) {
        return ResponseEntity.ok(ExerciseCreateMapper.map(createExercise.execute(ExerciseCreateMapper.map(exerciseCreateRequest))));
    }

    @DeleteMapping("detele/{id}")
    public ResponseEntity<ExerciseDeleteResponse> deleteEndPoint(@PathVariable String id) {
        return ResponseEntity.ok(ExerciseDeleteMapper.map(deleteExercise.execute(id), id, new User()));
    }

    @GetMapping("find-by/{id}")
    public ResponseEntity<ExerciseResponse> findByIdEndPoint(@PathVariable String id) {
        return ResponseEntity.ok(ExerciseMapper.map(findByIdExercise.execute(id)));
    }

    @GetMapping("find-by/{trainingId}")
    public ResponseEntity<List<ExerciseResponse>> findAllByTrainingIdEndPoint(@PathVariable String id) {
        List<ExerciseResponse> exerciseResponses = findAllByTrainingIdExercise.execute(id).stream()
                .map(ExerciseMapper::map)
                .collect(Collectors.toList());

        return ResponseEntity.ok(exerciseResponses);
    }

    @GetMapping("find-by/{userId}")
    public ResponseEntity<List<ExerciseResponse>> findAllByUserIdEndPoint(@PathVariable Long id) {
        List<ExerciseResponse> exerciseResponses = findAllByUserIdExercise.execute(id).stream()
                .map(ExerciseMapper::map)
                .collect(Collectors.toList());

        return ResponseEntity.ok(exerciseResponses);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<ExerciseUpdateResponse> updateEndPoint(@RequestBody ExerciseUpdateRequest exerciseUpdateRequest) {
        return ResponseEntity.ok(ExerciseUpdateMapper.map(updateExercise.execute(ExerciseUpdateMapper.map(exerciseUpdateRequest))));
    }

}
