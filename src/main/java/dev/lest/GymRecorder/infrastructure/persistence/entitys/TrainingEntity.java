package dev.lest.GymRecorder.infrastructure.persistence.entitys;


import dev.lest.GymRecorder.core.enuns.DayWeek;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;
import java.util.List;

@Data
@Builder
@Document(collection = "training")
@NoArgsConstructor
@AllArgsConstructor
public class TrainingEntity {

    @Id
    private String id;
    private String name;
    private DayWeek dayWeek;
    private List<ExerciseEntity> exercises;
    private Duration duration;
    private UsersEntity user;

}
