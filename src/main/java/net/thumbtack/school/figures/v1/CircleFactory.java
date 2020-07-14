package net.thumbtack.school.figures.v1;

import java.util.ArrayList;

public class CircleFactory {
    private static ArrayList<Circle> circles = new ArrayList<>();

    public static Circle createCircle(Point2D center, int radius) {
        Circle circle = new Circle(center, radius);
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
