package dev.lest.GymRecorder.infrastructure.beans;

import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Training.classes.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrainingBeanConfiguration {
    @Bean
    public CreateTrainingCaseImp createTrainingCaseImp(TrainingGateway trainingGateway,
                                                       ExerciseGateway exerciseGateway,
                                                       UserGateway userGateway){
        return new CreateTrainingCaseImp(trainingGateway, exerciseGateway, userGateway);
    }

    @Bean
    public DeleteTrainingCaseImp deleteTrainingCaseImp(TrainingGateway trainingGateway){
        return new DeleteTrainingCaseImp(trainingGateway);
    }

    @Bean
    public FindAllByUserIdTrainingCaseImp findAllByUserIdTrainingCaseImp(TrainingGateway trainingGateway, UserGateway userGateway){
        return new FindAllByUserIdTrainingCaseImp(trainingGateway, userGateway);
    }

    @Bean
    public FindByIdTrainingCaseImp findByIdTrainingCaseImp(TrainingGateway trainingGateway){
        return new FindByIdTrainingCaseImp(trainingGateway);
    }

    @Bean
    public UpdateTrainingCaseImp updateTrainingCaseImp(TrainingGateway trainingGateway,
                                                       ExerciseGateway exerciseGateway,
                                                       UserGateway userGateway){
        return new UpdateTrainingCaseImp(trainingGateway, exerciseGateway, userGateway);
    }

}
