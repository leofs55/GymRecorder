package dev.lest.GymRecorder.core.usecases.Exercise.classes;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.entities.Training;
import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.interfaces.UpdateExerciseCase;

import java.time.Duration;

public class UpdateExerciseCaseImp implements UpdateExerciseCase {

    private final ExerciseGateway exerciseGateway;
    private final UserGateway userGateway;

    public UpdateExerciseCaseImp(ExerciseGateway exerciseGateway, UserGateway userGateway) {
        this.exerciseGateway = exerciseGateway;
        this.userGateway = userGateway;
    }

    @Override
    public Exercise execute(Exercise exercise) {
        try {
            Exercise exerciseToUpdate = exerciseGateway.findExerciseById(exercise.getId())
                    .orElseThrow( () -> new RuntimeException("Error Update: Exercise not exist!"));

            User user = exercise.getUser();
            if (userGateway.existsById(user.getId())) {
                if (!user.getId().equals(exerciseToUpdate.getUser().getId())) {
                    throw new RuntimeException("Error Update: This exercise is not from this user!");
                }
            } else {
                throw new RuntimeException("Error Update: User not exist!");
            }

            String name = (exercise.getName() == null) ? exerciseToUpdate.getId() : exercise.getName();
            Integer repetitions = (exercise.getRepetitions() == null) ? exerciseToUpdate.getRepetitions() : exercise.getRepetitions();
            Integer sets = (exercise.getSets() == null) ? exerciseToUpdate.getSets() : exercise.getSets();
            Double weight = (exercise.getWeight() == null) ? exerciseToUpdate.getWeight() : exercise.getWeight();
            Duration restTime = (exercise.getRestTime() == null) ? exerciseToUpdate.getRestTime() : exercise.getRestTime();

            Exercise newExercise = new Exercise(exerciseToUpdate.getId(), name, repetitions, sets, weight, restTime, exerciseToUpdate.getUser());
            return exerciseGateway.updateExercise(newExercise);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
}
