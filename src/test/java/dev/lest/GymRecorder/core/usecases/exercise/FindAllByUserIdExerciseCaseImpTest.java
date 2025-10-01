package dev.lest.GymRecorder.core.usecases.exercise;

import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.classes.FindAllByUserIdExerciseCaseImp;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class FindAllByUserIdExerciseCaseImpTest {

    @Mock
    private ExerciseGateway exerciseGateway;

    @Mock
    private UserGateway userGateway;

    @InjectMocks
    private FindAllByUserIdExerciseCaseImp exerciseCaseImp;

    public void shouldExecuteOnSuccess() {}

    public void shouldExecuteOnFailure() {}

}

