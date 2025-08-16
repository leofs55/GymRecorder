package dev.lest.GymRecorder.infrastructure.persistence.interfaces;

import dev.lest.GymRecorder.infrastructure.persistence.entitys.ExerciseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExerciseRepository extends MongoRepository<ExerciseEntity, String> {
}
