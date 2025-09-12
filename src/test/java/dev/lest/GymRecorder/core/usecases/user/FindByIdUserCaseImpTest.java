package dev.lest.GymRecorder.core.usecases.user;

import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.core.enuns.Role;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Users.classes.FindByIdUserCaseImp;
import dev.lest.GymRecorder.infrastructure.exception.User.UserNotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class FindByIdUserCaseImpTest {

    @Mock
    private UserGateway userGateway;

    @InjectMocks
    private FindByIdUserCaseImp userCaseImp;

    @Test
    public void shouldReturnUserWhenUserIsFound(){
        Long userId = 1L;
        User expectedUser = new User(
                userId,
                "Leonardo Figorelli Santana",
                "email@email.com",
                "Senha123!",
                Role.USER
        );

        when(userGateway.findUserById(userId)).thenReturn(Optional.of(expectedUser));

        User user = userCaseImp.execute(userId);
        assertThat(user).isNotNull();
        assertThat(user.getId()).isEqualTo(expectedUser.getId());
        assertThat(user.getName()).isEqualTo(expectedUser.getName());

        verify(userGateway, times(1)).findUserById(userId);
    }

    @Test
    public void shouldReturnWhenUserIsWhenUserIsNotFound(){
        Long nonExistentUserId = 999999999999L;

        when(userGateway.findUserById(nonExistentUserId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userCaseImp.execute(nonExistentUserId))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessage("User Error: User not found!");
    }
}
