package dev.lest.GymRecorder.core.entities.Training;

import dev.lest.GymRecorder.core.entities.Exercise.Exercise;
import dev.lest.GymRecorder.core.entities.Users.User;
import dev.lest.GymRecorder.core.enuns.DayWeek;

import java.time.Duration;
import java.util.List;

public record Training(String id,
                       String name,
                       DayWeek dayWeek,
                       List<Exercise> exercises,
                       Duration duration,
                       User user) {
}
