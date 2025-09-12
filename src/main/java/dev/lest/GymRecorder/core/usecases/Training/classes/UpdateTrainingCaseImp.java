package dev.lest.GymRecorder.core.usecases.Training.classes;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.entities.Training;
import dev.lest.GymRecorder.core.entities.User;
import dev.lest.GymRecorder.core.enuns.DayWeek;
import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.gateway.TrainingGateway;
import dev.lest.GymRecorder.core.gateway.UserGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.classes.FindAllByListIdExerciseCaseImp;
import dev.lest.GymRecorder.core.usecases.Training.interfaces.UpdateTrainingCase;
import dev.lest.GymRecorder.infrastructure.exception.Exercise.ExerciseNotFoundInFindAllByListIdException;
import dev.lest.GymRecorder.infrastructure.exception.Exercise.UserDoesNotMatchForUpdateException;
import dev.lest.GymRecorder.infrastructure.exception.Training.TrainingNotFoundException;
import dev.lest.GymRecorder.infrastructure.exception.User.UserNotFoundException;

import java.time.Duration;
import java.util.List;

public class UpdateTrainingCaseImp implements UpdateTrainingCase {

    private final TrainingGateway trainingGateway;
    private final ExerciseGateway exerciseGateway;
    private final UserGateway userGateway;

    public UpdateTrainingCaseImp(TrainingGateway trainingGateway, ExerciseGateway exerciseGateway, UserGateway userGateway) {
        this.trainingGateway = trainingGateway;
        this.exerciseGateway = exerciseGateway;
        this.userGateway = userGateway;
    }

    @Override
    public Training execute(Training training) {
        try {
            Training trainingToUpdate = trainingGateway.findTrainingById(training.getId())
                    .orElseThrow(() -> new TrainingNotFoundException("Training Error: User search for editing failed, user does not exist!"));

            User user = training.getUser();
            if (userGateway.existsById(user.getId())) {
                if (!user.getId().equals(trainingToUpdate.getUser().getId())) {
                    throw new UserDoesNotMatchForUpdateException("Training Error: This exercise is not from this user!");
                }
            } else {
                throw new UserNotFoundException("Training Error: User not found!");
            }

            if (trainingToUpdate.getExercises() != null) {
                List<Exercise> exerciseList = new FindAllByListIdExerciseCaseImp(exerciseGateway).execute(training.getExercises());
                trainingToUpdate.setExercises(exerciseList);
            }

            String name = (training.getName() == null) ? trainingToUpdate.getName() : training.getName();
            DayWeek dayWeek = (training.getDayWeek() == null) ? trainingToUpdate.getDayWeek() : training.getDayWeek();
            List<Exercise> exercises = (training.getExercises() == null) ? trainingToUpdate.getExercises() : training.getExercises();
            Duration duration = (training.getDuration() == null) ? trainingToUpdate.getDuration() : training.getDuration();

            Training newTraining = new Training(training.getId(), name, dayWeek, exercises, duration, training.getUser());
            return trainingGateway.updateTraining(newTraining);

        } catch (TrainingNotFoundException e) {
            throw new TrainingNotFoundException(e.getLocalizedMessage(), e);

        } catch (ExerciseNotFoundInFindAllByListIdException e) {
            throw new ExerciseNotFoundInFindAllByListIdException("Training Error: " + e.getLocalizedMessage(), e);

        } catch (UserDoesNotMatchForUpdateException e) {
            throw new UserDoesNotMatchForUpdateException(e.getLocalizedMessage(), e);

        } catch (UserNotFoundException e) {
            throw new UserNotFoundException(e.getLocalizedMessage(), e);

        } catch (RuntimeException e) {
            throw new RuntimeException("Training Error: Something in Creation Training Failed!");
        }
    }
}
