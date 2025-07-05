package dev.lest.GymRecorder.core.usecases.Training.classes;

import dev.lest.GymRecorder.core.entities.Training.Training;
import dev.lest.GymRecorder.core.usecases.Training.interfaces.FindAllByUserIdTrainingCase;

import java.util.List;

public class FindAllByUserIdTrainingCaseImp implements FindAllByUserIdTrainingCase {

    @Override
    public List<Training> execute(Long userId) {
        return List.of();
    }
}
