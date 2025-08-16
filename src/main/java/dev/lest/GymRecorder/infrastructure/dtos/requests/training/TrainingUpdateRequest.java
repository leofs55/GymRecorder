package dev.lest.GymRecorder.infrastructure.dtos.requests.training;

import dev.lest.GymRecorder.core.enuns.DayWeek;
import dev.lest.GymRecorder.infrastructure.dtos.requests.exercise.ExerciseUpdateRequest;

import java.time.Duration;
import java.util.List;

public record TrainingUpdateRequest(String id,
                                    String name,
                                    DayWeek dayWeek,
                                    List<ExerciseUpdateRequest> exerciseResponseList,
                                    Duration duration,
                                    Long userId) {
}
