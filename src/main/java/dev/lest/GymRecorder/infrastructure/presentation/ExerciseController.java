package dev.lest.GymRecorder.infrastructure.presentation;

import dev.lest.GymRecorder.infrastructure.dtos.requests.exercise.ExerciseCreateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.requests.exercise.ExerciseUpdateRequest;
import dev.lest.GymRecorder.infrastructure.dtos.responses.exercise.ExerciseCreateResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.exercise.ExerciseDeleteResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.exercise.ExerciseResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.exercise.ExerciseUpdateResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/exercise/")
public class ExerciseController {

    @PostMapping("create")
    public ExerciseCreateResponse createEndPoint(@RequestBody ExerciseCreateRequest exerciseCreateRequest) {
    }

    @DeleteMapping("detele/{id}")
    public ExerciseDeleteResponse deleteEndPoint(@PathVariable String id) {
    }

    @GetMapping("find-by/{id}")
    public ExerciseResponse findByIdEndPoint(@PathVariable String id) {
    }

    @GetMapping("find-by/{trainingId}")
    public List<ExerciseResponse> findAllByTrainingIdEndPoint(@PathVariable String id) {
    }

    @GetMapping("find-by/{userId}")
    public List<ExerciseResponse> findAllByUserIdEndPoint(@PathVariable Long id) {
    }

    @PatchMapping("update/{id}")
    public ExerciseUpdateResponse updateEndPoint(@RequestBody ExerciseUpdateRequest exerciseUpdateRequest) {
    }

}
