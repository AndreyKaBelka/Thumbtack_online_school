package net.thumbtack.school.figures.v2;

import java.util.ArrayList;

public class CircleFactory {
    private static ArrayList<Circle> circles = new ArrayList<>();

    public static Circle createCircle(Point2D center, int radius, int color) {
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
