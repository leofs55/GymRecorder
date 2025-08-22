package dev.lest.GymRecorder.core.usecases.Training.classes;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.entities.Training;
import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.core.enuns.DayWeek;
import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.classes.FindAllExerciseByListIdCaseImp;
import dev.lest.GymRecorder.core.usecases.Training.interfaces.UpdateTrainingCase;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class UpdateTrainingCaseImp implements UpdateTrainingCase {

    private final TrainingGateway trainingGateway;
    private final ExerciseGateway exerciseGateway;

    public UpdateTrainingCaseImp(TrainingGateway trainingGateway, ExerciseGateway exerciseGateway) {
        this.trainingGateway = trainingGateway;
        this.exerciseGateway = exerciseGateway;
    }

    @Override
    public Training execute(Training training) {
        try {
            Training trainingToUpdate = trainingGateway.findTrainingById(training.getId())
                    .orElseThrow( () -> new RuntimeException("User search for editing failed, user does not exist!") );

            if (trainingToUpdate.getExercises() != null) {
                List<Exercise> exerciseList = new FindAllExerciseByListIdCaseImp(exerciseGateway).execute(training.getExercises());
                trainingToUpdate.setExercises(exerciseList);
            }

            String name = (training.getName() == null) ? trainingToUpdate.getName() : training.getName();
            DayWeek dayWeek = (training.getDayWeek() == null) ? trainingToUpdate.getDayWeek() : training.getDayWeek();
            List<Exercise> exercises = (training.getExercises() == null) ? trainingToUpdate.getExercises() : training.getExercises();
            Duration duration = (training.getDuration() == null) ? trainingToUpdate.getDuration() : training.getDuration();

            Training newTraining = new Training(training.getId(), name, dayWeek, exercises, duration, training.getUser());
            return trainingGateway.updateTraining(newTraining);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
