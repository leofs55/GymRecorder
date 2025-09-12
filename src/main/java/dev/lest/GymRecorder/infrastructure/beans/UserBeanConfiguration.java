package dev.lest.GymRecorder.infrastructure.beans;

import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Users.classes.CreateUserCaseImp;
import dev.lest.GymRecorder.core.usecases.Users.classes.DeleteUserCaseImp;
import dev.lest.GymRecorder.core.usecases.Users.classes.FindByIdUserCaseImp;
import dev.lest.GymRecorder.core.usecases.Users.classes.UpdateUserCaseImp;  
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBeanConfiguration {

    @Bean
    public CreateUserCaseImp createUserCaseImp(UserGateway userGateway) {
        return new CreateUserCaseImp(userGateway);
    }

    @Bean
    public DeleteUserCaseImp deleteUserCaseImp(UserGateway userGateway){
        return new DeleteUserCaseImp(userGateway);
    }

    @Bean
    public FindByIdUserCaseImp findByIdUserCaseImp(UserGateway userGateway){
        return new FindByIdUserCaseImp(userGateway);
    }

    @Bean
    public UpdateUserCaseImp updateUserCaseImp(UserGateway userGateway){
        return new UpdateUserCaseImp(userGateway);
    }
}
