package dev.lest.GymRecorder.infrastructure.persistence.interfaces;

import dev.lest.GymRecorder.infrastructure.persistence.entitys.ExerciseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends MongoRepository<ExerciseEntity, String> {
    List<ExerciseEntity> findAllByUserId(Long userId);
    List<ExerciseEntity> findByIdIn(List<String> idList);
}
