package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;

import java.util.Objects;

public class Circle extends Figure {
    private Point2D center;
    private int radius;

    public Circle(Point2D center, int radius, Color color) throws ColorException {
        super(color);
        this.center = center;
        this.radius = radius;
    }

    public Circle(int xCenter, int yCenter, int radius, Color color) throws ColorException {
        this(new Point2D(xCenter, yCenter), radius, color);
    }

    public Circle(int radius, Color color) throws ColorException {
        this(new Point2D(0, 0), radius, color);
    }

    public Circle(Color color) throws ColorException {
        this(new Point2D(0, 0), 1, color);
    }

    public Circle(Point2D center, int radius, String color) throws ColorException {
        super(color);
        this.center = center;
        this.radius = radius;
    }

    public Circle(int xCenter, int yCenter, int radius, String color) throws ColorException {
        this(new Point2D(xCenter, yCenter), radius, color);
    }

    public Circle(int radius, String color) throws ColorException {
        this(new Point2D(0, 0), radius, color);
    }

    public Circle(String color) throws ColorException {
        this(new Point2D(0, 0), 1, color);
    }

    public Point2D getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void moveRel(int dx, int dy) {
        this.center.moveRel(dx, dy);
    }

    public void enlarge(int n) {
        this.radius = this.radius * n;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean isInside(int x, int y) {
        return (Math.pow(x - center.getX(), 2) + Math.pow(y - center.getY(), 2) <= radius * radius);
    }

    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius &&
                center.equals(circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), center, radius);
    }
}
