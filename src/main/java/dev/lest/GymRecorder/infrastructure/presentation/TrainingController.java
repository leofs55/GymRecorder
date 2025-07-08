package dev.lest.GymRecorder.infrastructure.presentation;

import dev.lest.GymRecorder.infrastructure.dtos.requests.training.TrainingCreateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.requests.training.TrainingUpdateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.responses.training.TrainingCreateResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.training.TrainingDeleteResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.training.TrainingResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.training.TrainingUpdateResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/training/")
public class TrainingController {

    @PostMapping("create")
    public TrainingCreateResponse createEndPoint(@RequestBody TrainingCreateRequest trainingCreateRequest) {
    }

    @DeleteMapping("detele/{id}")
    public TrainingDeleteResponse deleteEndPoint(@PathVariable String id) {
    }

    @GetMapping("find-by/{id}")
    public TrainingResponse findByIdEndPoint(@PathVariable String id) {
    }

    @GetMapping("find-by/{userId}")
    public List<TrainingResponse> findAllByUserIdEndPoint(@PathVariable Long id) {
    }

    @PatchMapping("update/{id}")
    public TrainingUpdateResponse updateEndPoint(@PathVariable String id,
                                                 @RequestBody TrainingUpdateRequest trainingUpdateRequest) {
    }
}
