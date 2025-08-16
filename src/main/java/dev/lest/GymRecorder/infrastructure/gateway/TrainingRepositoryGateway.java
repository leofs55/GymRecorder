package dev.lest.GymRecorder.infrastructure.gateway;

import dev.lest.GymRecorder.core.entities.Training.Training;
import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.infrastructure.persistence.interfaces.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TrainingRepositoryGateway implements TrainingGateway {

    private final TrainingRepository repository;

    @Override
    public Training createTraining(Training training) {
        return null;
    }

    @Override
    public Training updateTraining(Training training) {
        return null;
    }

    @Override
    public Boolean deleteTraining(String id) {
        return null;
    }

    @Override
    public Optional<Training> findTrainingById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Training> findAllTrainingByUserId(Long id) {
        return List.of();
    }
}
