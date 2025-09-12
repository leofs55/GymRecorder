package dev.lest.GymRecorder.core.usecases.training;

import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.core.usecases.Training.classes.FindByIdTrainingCaseImp;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class FindByIdTrainingCaseImpTest {

    @Mock
    private TrainingGateway trainingGateway;

    @InjectMocks
    private FindByIdTrainingCaseImp trainingCaseImp;

    public void shouldExecuteOnSuccess() {}
}
