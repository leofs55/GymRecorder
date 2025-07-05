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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer repetitions;
    @NotNull
    private Integer sets;
    @NotNull
    private Double weight;
    @NotNull
    private Duration restTime;
    @NotNull
    private Long trainingId;
    @NotNull
    private Long userId;

}
