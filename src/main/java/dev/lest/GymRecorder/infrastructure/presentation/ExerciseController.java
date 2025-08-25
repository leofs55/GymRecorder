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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/exercise/")
@RequiredArgsConstructor
public class ExerciseController {

    private final CreateExerciseCase createExercise;
    private final DeleteExerciseCase deleteExercise;
    private final FindAllByUserIdExerciseCase findAllByUserIdExercise;
    private final FindByIdExerciseCase findByIdExercise;
    private final UpdateExerciseCase updateExercise;

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createEndPoint(@RequestBody ExerciseCreateRequest exerciseCreateRequest) {
        ExerciseCreateResponse exerciseCreateResponse = ExerciseCreateMapper.map(
                createExercise.execute(ExerciseCreateMapper.map(exerciseCreateRequest))
        );
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", "Exercice created with sucess!");
        responseHashMap.put("Exercise:", exerciseCreateResponse);
        return ResponseEntity.ok(responseHashMap);
    }

    @DeleteMapping("detele/{id}")
    public ResponseEntity<Map<String, Object>> deleteEndPoint(@PathVariable String id) {
        ExerciseDeleteResponse exerciseDeleteResponse = ExerciseDeleteMapper.map(deleteExercise.execute(id), id, new User());
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", exerciseDeleteResponse.result());
        responseHashMap.put("Exercise:", exerciseDeleteResponse);
        return ResponseEntity.ok(responseHashMap);
    }

    @GetMapping("find-by/{id}")
    public ResponseEntity<Map<String, Object>> findByIdEndPoint(@PathVariable String id) {
        ExerciseResponse exerciseResponse = ExerciseMapper.map(findByIdExercise.execute(id));
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", "Exercice found with sucess!");
        responseHashMap.put("Exercise:", exerciseResponse);
        return ResponseEntity.ok(responseHashMap);
    }

    @GetMapping("find-by/{userId}")
    public ResponseEntity<Map<String, Object>> findAllByUserIdEndPoint(@PathVariable Long id) {
        List<ExerciseResponse> exerciseResponses = findAllByUserIdExercise.execute(id).stream()
                .map(ExerciseMapper::map)
                .collect(Collectors.toList());

        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", "All exercises of user found with sucess!");
        responseHashMap.put("Exercise:", exerciseResponses);
        return ResponseEntity.ok(responseHashMap);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<Map<String, Object>> updateEndPoint(@PathVariable String id,
                                                                 @RequestBody ExerciseUpdateRequest exerciseUpdateRequest) {
        ExerciseUpdateResponse exerciseUpdateResponse = ExerciseUpdateMapper.map(updateExercise.execute(ExerciseUpdateMapper.map(exerciseUpdateRequest)));
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", "Exercise updated with sucess!");
        responseHashMap.put("Exercise:", exerciseUpdateResponse);
        return ResponseEntity.ok(responseHashMap);
    }

}
