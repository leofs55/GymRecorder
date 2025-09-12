package dev.lest.GymRecorder.core.usecases.exercise;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.classes.FindAllByListIdExerciseCaseImp;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class FindAllByListIdExerciseCaseImpTest {

    @Mock
    private ExerciseGateway exerciseGateway;

    @InjectMocks
    private FindAllByListIdExerciseCaseImp exerciseCaseImp;

    public void shouldExecuteOnSuccess() {}

}
