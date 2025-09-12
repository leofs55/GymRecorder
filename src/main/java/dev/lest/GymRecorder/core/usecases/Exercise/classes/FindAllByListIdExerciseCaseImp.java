package dev.lest.GymRecorder.core.usecases.Exercise.classes;

import dev.lest.GymRecorder.core.entities.Exercise;
import dev.lest.GymRecorder.core.gateway.ExerciseGateway;
import dev.lest.GymRecorder.core.usecases.Exercise.interfaces.FindAllExerciseByListIdCase;
import dev.lest.GymRecorder.infrastructure.exception.Exercise.ExerciseNotFoundInFindAllByListIdException;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllByListIdExerciseCaseImp implements FindAllExerciseByListIdCase {

    private final ExerciseGateway exerciseGateway;

    public FindAllByListIdExerciseCaseImp(ExerciseGateway exerciseGateway) {
        this.exerciseGateway = exerciseGateway;
    }

    @Override
    public List<Exercise> execute(List<Exercise> list) {
        try {
            List<String> listId = list.stream()
                    .map(Exercise::getId)
                    .collect(Collectors.toList());
            return exerciseGateway.findAllExerciseByListId(listId);

        } catch (ExerciseNotFoundInFindAllByListIdException e) {
            throw new ExerciseNotFoundInFindAllByListIdException("Error Exercise: Some id in list of exercise's, does not exist!", e);
        }
    }
}
