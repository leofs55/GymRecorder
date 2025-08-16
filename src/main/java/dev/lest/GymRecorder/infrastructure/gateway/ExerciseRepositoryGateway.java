package dev.lest.GymRecorder.infrastructure.gateway;

import dev.lest.GymRecorder.core.entities.Exercise.Exercise;
import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.infrastructure.persistence.interfaces.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExerciseRepositoryGateway implements ExerciseGateway {

    private final ExerciseRepository repository;

    @Override
    public Exercise createExercise(Exercise training) {
        return null;
    }

    @Override
    public Exercise updateExercise(Exercise training) {
        return null;
    }

    @Override
    public Boolean deleteExercise(String id) {
        return null;
    }

    @Override
    public Optional<Exercise> findExerciseById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Exercise> findAllExerciseByTrainingId(Long id) {
        return List.of();
    }

    @Override
    public List<Exercise> findAllExerciseByUserId(Long id) {
        return List.of();
    }
}
