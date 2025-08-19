package dev.lest.GymRecorder.infrastructure.beans;

import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.classes.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExerciseBeanConfiguration {

    @Bean
    public CreateExerciseCaseImp createExerciseCaseImp(ExerciseGateway exerciseGateway) {
        return new CreateExerciseCaseImp(exerciseGateway);
    }

    @Bean
    public DeleteExerciseCaseImp deleteExerciseCaseImp(ExerciseGateway exerciseGateway) {
        return new DeleteExerciseCaseImp(exerciseGateway);
    }

    @Bean
    public FindAllByTrainingIdExerciseCaseImp findAllByTrainingIdExerciseCaseImp(ExerciseGateway exerciseGateway) {
        return new FindAllByTrainingIdExerciseCaseImp(exerciseGateway);
    }

    @Bean
    public FindAllByUserIdExerciseCaseImp findAllByUserIdExerciseCaseImp(ExerciseGateway exerciseGateway) {
        return new FindAllByUserIdExerciseCaseImp(exerciseGateway);
    }

    @Bean
    public FindByIdExerciseCaseImp findByIdExerciseCaseImp(ExerciseGateway exerciseGateway) {
        return new FindByIdExerciseCaseImp(exerciseGateway);
    }

    @Bean
    public UpdateExerciseCaseImp updateExerciseCaseImp(ExerciseGateway exerciseGateway){
        return new UpdateExerciseCaseImp(exerciseGateway);
    }
}
