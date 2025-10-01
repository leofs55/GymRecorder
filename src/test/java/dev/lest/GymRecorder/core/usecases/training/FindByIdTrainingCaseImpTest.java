package dev.lest.GymRecorder.core.usecases.training;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.entities.Training;
import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.core.enuns.DayWeek;
import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.core.usecases.Training.classes.FindByIdTrainingCaseImp;
import dev.lest.GymRecorder.infrastructure.exception.Training.TrainingNotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class FindByIdTrainingCaseImpTest {

    @Mock
    private TrainingGateway trainingGateway;

    @InjectMocks
    private FindByIdTrainingCaseImp trainingCaseImp;

    @Test
    public void shouldExecuteOnSuccess() {
        String trainingId = "507f191e810c19729de860ea";
        Training expectedTraining = new Training(
            trainingId,
            "Treino de Peito",
            DayWeek.MONDAY,
            List.of(
                    new Exercise(),
                    new Exercise()),
            Duration.ofMinutes(120L),
            new User()
        );

        when(trainingGateway.findTrainingById(trainingId)).thenReturn(Optional.of(expectedTraining));

        Training training = trainingCaseImp.execute(trainingId);
        assertThat(training).isNotNull();
        assertThat(training).isEqualTo(expectedTraining);

        verify(trainingGateway, times(1)).findTrainingById(trainingId);
    }

    @Test
    public void shouldExecuteOnFailure() {
        String nonExistentExerciseId = "507f191e810c19729de860ea";

        when(trainingGateway.findTrainingById(nonExistentExerciseId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> trainingCaseImp.execute(nonExistentExerciseId))
                .isInstanceOf(TrainingNotFoundException.class)
                .hasMessage("Training not exist");

    }
}
