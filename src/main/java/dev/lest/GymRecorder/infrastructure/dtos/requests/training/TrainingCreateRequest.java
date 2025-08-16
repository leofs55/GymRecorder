package dev.lest.GymRecorder.infrastructure.dtos.requests.training;

import dev.lest.GymRecorder.core.enuns.DayWeek;
import dev.lest.GymRecorder.infrastructure.dtos.requests.exercise.ExerciseCreateRequest;

import java.time.Duration;
import java.util.List;

public record TrainingCreateRequest(String name,
                                    DayWeek dayWeek,
                                    List<ExerciseCreateRequest> exerciseResponseList,
                                    Duration duration,
                                    Long userId) {
}
