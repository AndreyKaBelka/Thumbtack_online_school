package net.thumbtack.school.ttschool;

import java.util.*;

public class Group {
    private String name;
    private String room;
    private List<Trainee> trainees;

    public Group(String name, String room) throws TrainingException {
        setName(name);
        setRoom(room);
        trainees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.equals("")) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) throws TrainingException {
        if (room == null || room.equals("")) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }
        this.room = room;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (!trainees.remove(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public void removeTrainee(int index) throws TrainingException {
        if (index < 0 || index >= trainees.size()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        trainees.remove(index);
    }

    public Trainee getTraineeByFirstName(String firstName) throws TrainingException {
        for (int i = 0; i < trainees.size(); i++) {
            if (trainees.get(i).getFirstName().equals(firstName)) {
                return trainees.get(i);
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Trainee getTraineeByFullName(String fullName) throws TrainingException {
        for (int i = 0; i < trainees.size(); i++) {
            if (trainees.get(i).getFullName().equals(fullName)) {
                return trainees.get(i);
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void sortTraineeListByFirstNameAscendant() {
        trainees.sort(Comparator.comparing(Trainee::getFirstName));
    }

    public void sortTraineeListByRatingDescendant() {
        trainees.sort(Comparator.comparing(Trainee::getRating, Comparator.reverseOrder()));
    }

    public void reverseTraineeList() {
        Collections.reverse(trainees);
    }

    public void rotateTraineeList(int positions) {
        Collections.rotate(trainees, positions);
    }

    public List<Trainee> getTraineesWithMaxRating() throws TrainingException {
        ArrayList<Trainee> traineeWithMaxRating = new ArrayList<>();
        int maxRating = 0;
        for (Trainee trainee : trainees) {
            if (maxRating < trainee.getRating()) {
                maxRating = trainee.getRating();
                traineeWithMaxRating.clear();
                traineeWithMaxRating.add(trainee);
            } else if (maxRating == trainee.getRating()) {
                traineeWithMaxRating.add(trainee);
            }
        }
        if (traineeWithMaxRating.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        return traineeWithMaxRating;
    }

    public boolean hasDuplicates() {
        return new HashSet<>(trainees).size() != trainees.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return name.equals(group.name) &&
                room.equals(group.room) &&
                trainees.equals(group.trainees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, room, trainees);
    }
}