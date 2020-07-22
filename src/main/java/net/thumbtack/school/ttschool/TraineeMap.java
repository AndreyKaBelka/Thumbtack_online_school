package net.thumbtack.school.ttschool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TraineeMap {
    private Map<Trainee, String> institutes;

    public TraineeMap(){
        institutes = new HashMap<>();
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (institutes.containsKey(trainee)){
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }
        institutes.put(trainee, institute);
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (institutes.containsKey(trainee)){
            institutes.replace(trainee, institute);
        } else {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {
        if (!institutes.containsKey(trainee)){
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        institutes.remove(trainee);
    }

    public int getTraineesCount(){
        return institutes.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
        if (!institutes.containsKey(trainee)){
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        return institutes.get(trainee);
    }

    public Set<Trainee> getAllTrainees(){
        return institutes.keySet();
    }

    public Set<String> getAllInstitutes(){
        return new HashSet<>(institutes.values());
    }

    public boolean isAnyFromInstitute(String institute){
        return institutes.containsValue(institute);
    }

}
