package dev.lest.GymRecorder.infrastructure.dtos.responses.training;

import dev.lest.GymRecorder.core.enuns.DayWeek;
import dev.lest.GymRecorder.infrastructure.dtos.responses.exercise.ExerciseUpdateResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserUpdateResponse;
import lombok.Builder;

import java.time.Duration;
import java.util.List;

@Builder
public record TrainingUpdateResponse(String id,
                                     String name,
                                     DayWeek dayWeek,
                                     List<ExerciseUpdateResponse> exerciseResponseList,
                                     Duration duration,
                                     UserUpdateResponse userResponse) {
}
