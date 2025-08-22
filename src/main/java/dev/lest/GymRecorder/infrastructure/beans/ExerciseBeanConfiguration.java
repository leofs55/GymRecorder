package dev.lest.GymRecorder.infrastructure.beans;

import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.classes.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExerciseBeanConfiguration {

    @Bean
    public CreateExerciseCaseImp createExerciseCaseImp(ExerciseGateway exerciseGateway, UserGateway userGateway) {
        return new CreateExerciseCaseImp(exerciseGateway, userGateway);
    }

    @Bean
    public DeleteExerciseCaseImp deleteExerciseCaseImp(ExerciseGateway exerciseGateway) {
        return new DeleteExerciseCaseImp(exerciseGateway);
    }

    @Bean
    public FindAllByUserIdExerciseCaseImp findAllByUserIdExerciseCaseImp(ExerciseGateway exerciseGateway, UserGateway userGateway) {
        return new FindAllByUserIdExerciseCaseImp(exerciseGateway, userGateway);
    }

    @Bean
    public FindByIdExerciseCaseImp findByIdExerciseCaseImp(ExerciseGateway exerciseGateway) {
        return new FindByIdExerciseCaseImp(exerciseGateway);
    }

    @Bean
    public UpdateExerciseCaseImp updateExerciseCaseImp(ExerciseGateway exerciseGateway, UserGateway userGateway){
        return new UpdateExerciseCaseImp(exerciseGateway, userGateway);
    }

    @Bean
    public FindAllExerciseByListIdCaseImp findAllExerciseByListIdCaseImp(ExerciseGateway exerciseGateway) {
        return new FindAllExerciseByListIdCaseImp(exerciseGateway);
    }
}
