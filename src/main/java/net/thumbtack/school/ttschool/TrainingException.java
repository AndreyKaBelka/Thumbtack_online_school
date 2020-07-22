package net.thumbtack.school.ttschool;

public class TrainingException extends Exception {
    private TrainingErrorCode errorCode;

    public TrainingErrorCode getErrorCode() {
        return errorCode;
    }

    TrainingException(TrainingErrorCode errorCode){
        this.errorCode = errorCode;
    }
}
