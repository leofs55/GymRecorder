package dev.lest.GymRecorder.infrastructure.presentation;

import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.core.usecases.Training.interfaces.*;
import dev.lest.GymRecorder.infrastructure.dtos.requests.training.TrainingCreateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.requests.training.TrainingUpdateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.responses.training.TrainingCreateResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.training.TrainingDeleteResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.training.TrainingResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.training.TrainingUpdateResponse;
import dev.lest.GymRecorder.infrastructure.mappers.training.TrainingCreateMapper;
import dev.lest.GymRecorder.infrastructure.mappers.training.TrainingDeleteMapper;
import dev.lest.GymRecorder.infrastructure.mappers.training.TrainingMapper;
import dev.lest.GymRecorder.infrastructure.mappers.training.TrainingUpdateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/training/")
@RequiredArgsConstructor
public class TrainingController {

    private final CreateTrainingCase createTraining;
    private final DeleteTrainingCase deleteTraining;
    private final FindAllByUserIdTrainingCase findAllByUserIdTraining;
    private final FindByIdTrainingCase findByIdTraining;
    private final UpdateTrainingCase updateTraining;

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createEndPoint(@RequestBody TrainingCreateRequest trainingCreateRequest) {
        TrainingCreateResponse trainingCreateResponse = TrainingCreateMapper.map(createTraining.execute(TrainingCreateMapper.map(trainingCreateRequest)));
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", "Training created successfully!");
        responseHashMap.put("Training:", responseHashMap);
        return ResponseEntity.ok(responseHashMap);
    }

    @DeleteMapping("detele/{id}")
    public ResponseEntity<Map<String, Object>> deleteEndPoint(@PathVariable String id) {
        TrainingDeleteResponse trainingDeleteResponse = TrainingDeleteMapper.map(deleteTraining.execute(id), id, new User());
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", trainingDeleteResponse.result());
        responseHashMap.put("Training:", responseHashMap);
        return ResponseEntity.ok(responseHashMap);
    }

    @GetMapping("find-by/{id}")
    public ResponseEntity<Map<String, Object>> findByIdEndPoint(@PathVariable String id) {
        TrainingResponse trainingResponse = TrainingMapper.map(findByIdTraining.execute(id));
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", "Training successfully found!");
        responseHashMap.put("Training:", responseHashMap);
        return ResponseEntity.ok(responseHashMap);
    }

    @GetMapping("find-by/{userId}")
    public ResponseEntity<Map<String, Object>> findAllByUserIdEndPoint(@PathVariable Long id) {
        List<TrainingResponse> trainingResponses = findAllByUserIdTraining.execute(id).stream()
                .map(TrainingMapper::map)
                .collect(Collectors.toList());

        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", "All user trainings were met successfully");
        responseHashMap.put("Training:", responseHashMap);
        return ResponseEntity.ok(responseHashMap);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<Map<String, Object>> updateEndPoint(@PathVariable String id,
                                                 @RequestBody TrainingUpdateRequest trainingUpdateRequest) {
        TrainingUpdateResponse trainingUpdateResponse = TrainingUpdateMapper.map(updateTraining.execute(TrainingUpdateMapper.map(trainingUpdateRequest, id)));
        Map<String, Object> responseHashMap = new HashMap<>();
        responseHashMap.put("Message:", "Training are successfully updated!");
        responseHashMap.put("Training:", responseHashMap);
        return ResponseEntity.ok(responseHashMap);
    }
}
