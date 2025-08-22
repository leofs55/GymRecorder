package dev.lest.GymRecorder.core.usecases.Training.classes;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.entities.Training;
import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.classes.FindAllExerciseByListIdCaseImp;
import dev.lest.GymRecorder.core.usecases.Training.interfaces.CreateTrainingCase;

import java.util.List;
import java.util.stream.Collectors;

public class CreateTrainingCaseImp implements CreateTrainingCase {

    private final TrainingGateway trainingGateway;
    private final ExerciseGateway exerciseGateway;
    private final UserGateway userGateway;

    public CreateTrainingCaseImp(TrainingGateway trainingGateway, ExerciseGateway exerciseGateway, UserGateway userGateway) {
        this.trainingGateway = trainingGateway;
        this.exerciseGateway = exerciseGateway;
        this.userGateway = userGateway;
    }

    @Override
    public Training execute(Training training) {
        try {

            if (training.getExercises() != null) {
                List<Exercise> exerciseList = new FindAllExerciseByListIdCaseImp(exerciseGateway).execute(training.getExercises());
                training.setExercises(exerciseList);
            }

            User user = userGateway.findUserById(training.getUser().getId())
                    .orElseThrow( () -> new RuntimeException("Training creation failed! User not exist!") );
            training.setUser(user);

            return trainingGateway.createTraining(training); //TODO: Criar Exception especifica.
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
