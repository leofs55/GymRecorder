package dev.lest.GymRecorder.core.usecases.exercise;

import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.classes.CreateExerciseCaseImp;
import dev.lest.GymRecorder.core.usecases.Exercise.classes.DeleteExerciseCaseImp;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class DeleteExerciseCaseImpTest {

    @Mock
    private ExerciseGateway exerciseGateway;

    @InjectMocks
    private DeleteExerciseCaseImp exerciseCaseImp;

    public void shouldExecuteOnSuccess() {}

}
