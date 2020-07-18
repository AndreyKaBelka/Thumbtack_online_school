package net.thumbtack.school.figures.v2;

import java.util.Objects;

public abstract class Figure implements Colored {
    private int color;

    Figure(int color) {
        this.color = color;
    }

    public abstract void moveRel(int dx, int dy);

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract boolean isInside(int x, int y);

    public abstract boolean isInside(Point2D point);

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return color == figure.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
