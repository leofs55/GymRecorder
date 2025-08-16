package dev.lest.GymRecorder.infrastructure.persistence.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;


@Data
@Document(collection = "exercise")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseEntity {

    @Id
    private String id;
    private String name;
    private Integer repetitions;
    private Integer sets;
    private Double weight;
    private Duration restTime;
    private String trainingId;
    @JsonIgnore
    private UsersEntity user;

}
