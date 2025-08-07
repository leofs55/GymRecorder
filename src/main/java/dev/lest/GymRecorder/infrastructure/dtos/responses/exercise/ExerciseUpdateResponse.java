package dev.lest.GymRecorder.infrastructure.dtos.responses.exercise;

import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserExerciseResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserResponse;
import dev.lest.GymRecorder.infrastructure.dtos.responses.user.UserUpdateResponse;
import dev.lest.GymRecorder.infrastructure.mappers.users.UserUpdateMapper;
import lombok.Builder;

import java.time.Duration;

@Builder
public record ExerciseUpdateResponse(String id,
                                     String name,
                                     Integer repetitions,
                                     Integer sets,
                                     Double weight,
                                     Duration restTime,
                                     String traininId,
                                     UserExerciseResponse userResponse) {
}
