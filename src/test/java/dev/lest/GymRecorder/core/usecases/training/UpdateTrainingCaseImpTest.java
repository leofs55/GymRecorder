package dev.lest.GymRecorder.core.usecases.training;

import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Training.classes.CreateTrainingCaseImp;
import dev.lest.GymRecorder.core.usecases.Training.classes.UpdateTrainingCaseImp;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class UpdateTrainingCaseImpTest {

    @Mock
    private TrainingGateway trainingGateway;

    @Mock
    private UserGateway userGateway;

    @InjectMocks
    private UpdateTrainingCaseImp trainingCaseImp;

    public void shouldExecuteOnSuccess() {}

}
