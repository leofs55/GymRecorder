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

import java.util.List;
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
    public ResponseEntity<TrainingCreateResponse> createEndPoint(@RequestBody TrainingCreateRequest trainingCreateRequest) {
        return ResponseEntity.ok(TrainingCreateMapper.map(createTraining.execute(TrainingCreateMapper.map(trainingCreateRequest))));
    }

    @DeleteMapping("detele/{id}")
    public ResponseEntity<TrainingDeleteResponse> deleteEndPoint(@PathVariable String id) {
        return ResponseEntity.ok(TrainingDeleteMapper.map(deleteTraining.execute(id), id, new User()));
    }

    @GetMapping("find-by/{id}")
    public ResponseEntity<TrainingResponse> findByIdEndPoint(@PathVariable String id) {
        return ResponseEntity.ok(TrainingMapper.map(findByIdTraining.execute(id)));
    }

    @GetMapping("find-by/{userId}")
    public ResponseEntity<List<TrainingResponse>> findAllByUserIdEndPoint(@PathVariable Long id) {
        List<TrainingResponse> trainingResponses = findAllByUserIdTraining.execute(id).stream()
                .map(TrainingMapper::map)
                .collect(Collectors.toList());

        return ResponseEntity.ok(trainingResponses);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<TrainingUpdateResponse> updateEndPoint(@PathVariable String id,
                                                 @RequestBody TrainingUpdateRequest trainingUpdateRequest) {
        return ResponseEntity.ok(TrainingUpdateMapper.map(updateTraining.execute(TrainingUpdateMapper.map(trainingUpdateRequest))));
    }
}
