package dev.lest.GymRecorder.core.usecases.user;

import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Users.classes.CreateUserCaseImp;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class CreateUserCaseImpTest {

    @Mock
    private UserGateway userGateway;

    @InjectMocks
    private CreateUserCaseImp userCaseImp;

    public void shouldExecuteOnSuccess() {}

    public void shouldExecuteOnFailure() {}

}
