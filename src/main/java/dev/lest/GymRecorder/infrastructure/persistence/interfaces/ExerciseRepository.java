package dev.lest.GymRecorder.infrastructure.persistence.interfaces;

import dev.lest.GymRecorder.infrastructure.persistence.entitys.ExerciseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExerciseRepository extends MongoRepository<ExerciseEntity, String> {
    List<ExerciseEntity> findAllByUserId(Long userId);
    List<ExerciseEntity> findAllByTrainingId(String trainingId);
}
