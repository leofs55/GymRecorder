package dev.lest.GymRecorder.infrastructure.beans;

import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.core.usecases.Training.classes.*;
import dev.lest.GymRecorder.core.usecases.Training.interfaces.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrainingBeanConfiguration {
    @Bean
    public CreateTrainingCaseImp createTrainingCaseImp(TrainingGateway trainingGateway){
        return new CreateTrainingCaseImp(trainingGateway);
    }

    @Bean
    public DeleteTrainingCaseImp deleteTrainingCaseImp(TrainingGateway trainingGateway){
        return new DeleteTrainingCaseImp(trainingGateway);
    }

    @Bean
    public FindAllByUserIdTrainingCaseImp findAllByUserIdTrainingCaseImp(TrainingGateway trainingGateway){
        return new FindAllByUserIdTrainingCaseImp(trainingGateway);
    }

    @Bean
    public FindByIdTrainingCaseImp findByIdTrainingCaseImp(TrainingGateway trainingGateway){
        return new FindByIdTrainingCaseImp(trainingGateway);
    }

    @Bean
    public UpdateTrainingCaseImp updateTrainingCaseImp(TrainingGateway trainingGateway){
        return new UpdateTrainingCaseImp(trainingGateway);
    }

}
