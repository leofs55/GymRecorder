package dev.lest.GymRecorder.infrastructure.gateway;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.infrastructure.mappers.exercise.ExerciseGatewayMapper;
import dev.lest.GymRecorder.infrastructure.persistence.entitys.ExerciseEntity;
import dev.lest.GymRecorder.infrastructure.persistence.interfaces.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ExerciseRepositoryGateway implements ExerciseGateway {

    private final ExerciseRepository repository;

    @Override
    public Exercise createExercise(Exercise exercise) {
        ExerciseEntity exerciseToEntity = ExerciseGatewayMapper.map(exercise);
        ExerciseEntity savedExerciseEntity = repository.save(exerciseToEntity);
        return ExerciseGatewayMapper.map(savedExerciseEntity);
    }

    @Override
    public Exercise updateExercise(Exercise exercise) {
        ExerciseEntity exerciseToEntity = ExerciseGatewayMapper.map(exercise);
        ExerciseEntity savedExerciseEntity = repository.save(exerciseToEntity);
        return ExerciseGatewayMapper.map(savedExerciseEntity);
    }

    @Override
    public void deleteExercise(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Exercise> findExerciseById(String id) {
        Optional<ExerciseEntity> exerciseToEntity = repository.findById(id);
        return exerciseToEntity.map(ExerciseGatewayMapper::map);
    }

    @Override
    public List<Exercise> findAllExerciseByUserId(Long id) {
        List<ExerciseEntity> exerciseEntityList = repository.findAllByUserId(id);
        return exerciseEntityList.stream()
                .map(ExerciseGatewayMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<Exercise> findAllExerciseByListId(List<String> idList) {
        return repository.findByIdIn(idList).stream()
                .map(ExerciseGatewayMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean existsById(String id) {
        return repository.existsById(id);
    }
}
