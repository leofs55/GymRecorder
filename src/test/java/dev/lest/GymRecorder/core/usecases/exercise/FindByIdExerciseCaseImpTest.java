package dev.lest.GymRecorder.core.usecases.exercise;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.classes.FindByIdExerciseCaseImp;
import dev.lest.GymRecorder.infrastructure.exception.Exercise.ExerciseNotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class FindByIdExerciseCaseImpTest {

    @Mock
    private ExerciseGateway exerciseGateway;

    @InjectMocks
    private FindByIdExerciseCaseImp exerciseCaseImp;

    @Test
    public void shouldExecuteOnSuccess() {
        String exerciseId = "507f191e810c19729de860ea";
        Exercise expectExercise = new Exercise(
                exerciseId,
                "Supino Reto",
                12,
                4,
                120.0,
                Duration.ofMinutes(2L),
                new User()
        );

        when(exerciseGateway.findExerciseById(exerciseId)).thenReturn(Optional.of(expectExercise));

        Exercise exercise = exerciseCaseImp.execute(exerciseId);
        assertThat(exercise).isNotNull();
        assertThat(exercise).isEqualTo(expectExercise);

        verify(exerciseGateway, times(1)).findExerciseById(exerciseId);
    }

    @Test
    public void sholdExecuteOnFailure() {
        String nonExistentExerciseId = "A1B2C3D4E5F6G7H8I9J1K2L3";

        when(exerciseGateway.findExerciseById(nonExistentExerciseId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> exerciseCaseImp.execute(nonExistentExerciseId))
                .isInstanceOf(ExerciseNotFoundException.class)
                .hasMessage("Exercise Error: Exercise not exist!");

    }


}
