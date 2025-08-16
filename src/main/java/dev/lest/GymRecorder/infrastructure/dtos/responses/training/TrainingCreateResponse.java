package dev.lest.GymRecorder.infrastructure.dtos.responses.training;

import dev.lest.GymRecorder.core.enuns.DayWeek;
import dev.lest.GymRecorder.infrastructure.dtos.responses.exercise.ExerciseResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserCreateResponse;
import lombok.Builder;

import java.time.Duration;
import java.util.List;

@Builder
public record TrainingCreateResponse(String id,
                                     String name,
                                     DayWeek dayWeek,
                                     List<ExerciseResponse> exerciseResponseList,
                                     Duration duration,
                                     UserCreateResponse userResponse) {
}
