package dev.lest.GymRecorder.infrastructure.persistence.entitys;


import dev.lest.GymRecorder.core.entities.Exercise.Exercise;
import dev.lest.GymRecorder.core.enuns.DayWeek;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;
import java.util.List;

@Data
@Document(collection = "training")
@NoArgsConstructor
@AllArgsConstructor
public class Training {

    @Id
    private String id;
    private String name;
    private DayWeek dayWeek;
    private List<Exercise> exercises;
    private Duration duration;
    private Long userId;

}
