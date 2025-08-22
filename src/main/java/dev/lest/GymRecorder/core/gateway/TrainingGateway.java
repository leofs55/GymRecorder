package dev.lest.GymRecorder.core.gateway;

import dev.lest.GymRecorder.core.entities.Training;

import java.util.List;
import java.util.Optional;

public interface TrainingGateway {

    Training createTraining(Training training);
    Training updateTraining(Training training);
    void deleteTraining(String id);
    Optional<Training> findTrainingById(String id);
    List<Training> findAllTrainingByUserId(Long id);
    Boolean existsById(String id);

}
