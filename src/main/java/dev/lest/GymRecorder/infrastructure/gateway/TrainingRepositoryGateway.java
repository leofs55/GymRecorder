package dev.lest.GymRecorder.infrastructure.gateway;

import dev.lest.GymRecorder.core.entities.Training;
import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.infrastructure.mappers.training.TrainingGatewayMapper;
import dev.lest.GymRecorder.infrastructure.persistence.entitys.TrainingEntity;
import dev.lest.GymRecorder.infrastructure.persistence.interfaces.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TrainingRepositoryGateway implements TrainingGateway {

    private final TrainingRepository repository;

    @Override
    public Training createTraining(Training training) {
        TrainingEntity trainingToEntity = TrainingGatewayMapper.map(training);
        TrainingEntity savedTrainigEntity = repository.save(trainingToEntity);
        return TrainingGatewayMapper.map(savedTrainigEntity);
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
        Optional<TrainingEntity> findedTrainingEntity = repository.findById(id);
        return findedTrainingEntity.map(TrainingGatewayMapper::map);
    }

    @Override
    public List<Training> findAllTrainingByUserId(Long id) {
        List<TrainingEntity> listOfFindedTrainingEntity = repository.findAllByUserId(id);
        return listOfFindedTrainingEntity.stream()
                .map(TrainingGatewayMapper::map)
                .collect(Collectors.toList());
    }
}
