package net.thumbtack.school.colors;

public interface Colored {
    void setColor(Color color) throws ColorException;

    Color getColor();

    void setColor(String colorString) throws ColorException;
}
