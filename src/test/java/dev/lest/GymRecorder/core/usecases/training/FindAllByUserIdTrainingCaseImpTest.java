package dev.lest.GymRecorder.core.usecases.training;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.entities.Training;
import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.core.enuns.DayWeek;
import dev.lest.GymRecorder.core.enuns.Role;
import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Training.classes.FindAllByUserIdTrainingCaseImp;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class FindAllByUserIdTrainingCaseImpTest {

    @Mock
    private TrainingGateway trainingGateway;

    @Mock
    private UserGateway userGateway;

    @InjectMocks
    private FindAllByUserIdTrainingCaseImp trainingCaseImp;

    @Test
    public void shouldExecuteOnSuccess() {
        Long userId = 1L;

        when(userGateway.existsById(userId)).thenReturn(true);

        List<Training> expectedTrainings = List.of(

                new Training("507f191e810c19729de860ea", "Treino de Peito", DayWeek.MONDAY,
                        List.of(new Exercise(), new Exercise()), Duration.ofMinutes(120L), new User(userId)),

                new Training("507f191e810c19729de860eb", "Treino de Costa", DayWeek.TUESDAY,
                        List.of(new Exercise(), new Exercise()), Duration.ofMinutes(120L), new User(userId)),

                new Training("507f191e810c19729de860ec", "Treino de Perna", DayWeek.WEDNESDAY,
                        List.of(new Exercise(), new Exercise()), Duration.ofMinutes(120L), new User(userId))
        );

        when(trainingGateway.findAllTrainingByUserId(userId)).thenReturn(expectedTrainings);

        List<Training> trainingList = trainingCaseImp.execute(userId);

        assertThat(trainingList).isNotNull();

        verify(trainingGateway, times(1)).findAllTrainingByUserId(userId);
    }

    public void shouldExecuteOnFailure() {

    }

}
