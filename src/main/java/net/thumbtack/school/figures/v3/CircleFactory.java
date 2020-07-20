package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;

import java.util.ArrayList;

public class CircleFactory {
    private static ArrayList<Circle> circles = new ArrayList<>();

    public static Circle createCircle(Point2D center, int radius, Color color) throws ColorException {
        Circle circle = new Circle(center, radius, color);
        circles.add(circle);
        return circle;
    }

    public static Circle createCircle(Point2D center, int radius, String color) throws ColorException {
        Circle circle = new Circle(center, radius, color);
        circles.add(circle);
        return circle;
    }

    public static int getCircleCount() {
        return circles.size();
    }

    public static void reset() {
        circles.clear();
    }

}
