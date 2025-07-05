package dev.lest.GymRecorder.infrastructure.persistence.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;


@Data
@Document(collection = "exercise")
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

    @Id
    private String id;
    private String name;
    private Integer repetitions;
    private Integer sets;
    private Double weight;
    private Duration restTime;
    private Long trainingId;
    private Long userId;

}
