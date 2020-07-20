package net.thumbtack.school.colors;

public enum ColorErrorCode {
    WRONG_COLOR_STRING,
    NULL_COLOR;

    private String errorString;
    private ColorErrorCode(String errorString){
        this.errorString = errorString;
    }

    public String getErrorString(){
        return errorString;
    }

    ColorErrorCode() {}
}
