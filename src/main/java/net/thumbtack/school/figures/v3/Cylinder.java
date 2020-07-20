package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;

import java.util.Objects;

public class Cylinder extends Circle {
    private int height;

    public Cylinder(Point2D center, int radius, int height, Color color) throws ColorException {
        super(center, radius, color);
        this.height = height;
    }

    public Cylinder(int xCenter, int yCenter, int radius, int height, Color color) throws ColorException {
        super(xCenter, yCenter, radius, color);
        this.height = height;
    }

    public Cylinder(int radius, int height, Color color) throws ColorException {
        super(radius, color);
        this.height = height;
    }

    public Cylinder(Color color) throws ColorException {
        super(color);
        this.height = 1;
    }

    public Cylinder(Point2D center, int radius, int height, String color) throws ColorException {
        this(center, radius, height, Color.colorFromString(color));
    }

    public Cylinder(int xCenter, int yCenter, int radius, int height, String color) throws ColorException {
        this(xCenter, yCenter, radius, height, Color.colorFromString(color));
    }

    public Cylinder(int radius, int height, String color) throws ColorException {
        this(radius, height, Color.colorFromString(color));
    }

    public Cylinder(String color) throws ColorException {
        this(Color.colorFromString(color));
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * height;
    }

    public boolean isInside(int x, int y, int z) {
        return super.isInside(x, y) && z <= height;
    }

    public boolean isInside(Point3D point) {
        return this.isInside(point.getX(), point.getY(), point.getZ());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cylinder cylinder = (Cylinder) o;
        return height == cylinder.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height);
    }
}
