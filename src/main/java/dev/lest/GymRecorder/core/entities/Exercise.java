package dev.lest.GymRecorder.core.entities;

import java.time.Duration;

public class Exercise {

    private String id;
    private String name;
    private Integer repetitions;
    private Integer sets;
    private Double weight;
    private Duration restTime;
    private User user;

    public Exercise(String id, String name, Integer repetitions, Integer sets, Double weight, Duration restTime,
                    User user) {
        this.id = id;
        this.name = name;
        this.repetitions = repetitions;
        this.sets = sets;
        this.weight = weight;
        this.restTime = restTime;
        this.user = user;

    }

    public Exercise() {
    }

    public Exercise(String name, Integer repetitions, Integer sets,
                    Double weight, Duration restTime, User user) {
        this.name = name;
        this.repetitions = repetitions;
        this.sets = sets;
        this.weight = weight;
        this.restTime = restTime;
        this.user = user;

    }

    public Exercise(String id) {
        this.id = id;
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

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Duration getRestTime() {
        return restTime;
    }

    public void setRestTime(Duration restTime) {
        this.restTime = restTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
