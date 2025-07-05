package dev.lest.GymRecorder.core.entities.Training;

import dev.lest.GymRecorder.core.entities.Exercise.Exercise;
import dev.lest.GymRecorder.core.enuns.DaysWeek;

import java.time.Duration;
import java.util.List;

public record Training(Long id,
                       String name,
                       DaysWeek dayWeek,
                       List<Exercise> exercises,
                       Duration duration,
                       Long userId) {
}
