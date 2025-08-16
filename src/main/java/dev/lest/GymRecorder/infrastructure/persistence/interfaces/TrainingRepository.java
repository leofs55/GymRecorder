package dev.lest.GymRecorder.infrastructure.persistence.interfaces;

import dev.lest.GymRecorder.infrastructure.persistence.entitys.TrainingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrainingRepository extends MongoRepository<TrainingEntity, String> {
}
