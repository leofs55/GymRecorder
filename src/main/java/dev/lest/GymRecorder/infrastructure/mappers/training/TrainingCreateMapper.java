package dev.lest.GymRecorder.infrastructure.mappers.training;

import dev.lest.GymRecorder.infrastructure.dtos.requests.training.TrainingCreateRequest;
import dev.lest.GymRecorder.infrastructure.persistence.entitys.Training;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TrainingCreateMapper {

    public static Training map(TrainingCreateRequest trainingCreateRequest) {
        return Training.builder().build();
    }

}
