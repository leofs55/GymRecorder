package dev.lest.GymRecorder.core.usecases.user;

import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Users.classes.UpdateUserCaseImp;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class UpdateUserCaseImpTest {

    @Mock
    private UserGateway userGateway;

    @InjectMocks
    private UpdateUserCaseImp updateUserCaseImp;

    @Test
    public void shouldExecuteOnSuccess() {}

    @Test
    public void shouldExecuteOnFailure() {}

}
