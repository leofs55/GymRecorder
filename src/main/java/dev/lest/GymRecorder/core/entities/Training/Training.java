package dev.lest.GymRecorder.core.entities.Training;

import dev.lest.GymRecorder.core.entities.Exercise.Exercise;
import dev.lest.GymRecorder.core.entities.Users.User;
import dev.lest.GymRecorder.core.enuns.DayWeek;

import java.time.Duration;
import java.util.List;

public class Training {

    private String id;
    private String name;
    private DayWeek dayWeek;
    private List<Exercise> exercises;
    private Duration duration;
    private User user;

    public Training(String id, String name, DayWeek dayWeek, List<Exercise> exercises, Duration duration, User user) {
        this.id = id;
        this.name = name;
        this.dayWeek = dayWeek;
        this.exercises = exercises;
        this.duration = duration;
        this.user = user;
    }

    public Training() {
    }

    public Training(String id) {
        this.id = id;
    }

    public Training(String name, DayWeek dayWeek, List<Exercise> exercises, Duration duration, User user) {
        this.name = name;
        this.dayWeek = dayWeek;
        this.exercises = exercises;
        this.duration = duration;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DayWeek getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(DayWeek dayWeek) {
        this.dayWeek = dayWeek;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
