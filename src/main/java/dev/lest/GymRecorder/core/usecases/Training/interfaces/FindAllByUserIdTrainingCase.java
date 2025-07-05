package dev.lest.GymRecorder.core.usecases.Training.interfaces;

import dev.lest.GymRecorder.core.entities.Training.Training;

import java.util.List;

public interface FindAllByUserIdTrainingCase {

    List<Training> execute(Long userId);

}
