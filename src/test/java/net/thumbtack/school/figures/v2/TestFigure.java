package net.thumbtack.school.figures.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFigure {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testCompareColors() {
        Figure rect = new Rectangle(10, 20, 30, 40, 1);
        Figure circle = new Circle(10, 20, 10, 1);
        assertEquals(rect.getColor(), circle.getColor());
        circle.setColor(2);
        assertNotEquals(rect.getColor(), circle.getColor());
    }

    @Test
    public void testSetColors() {
        Figure[] figures = new Figure[3];
        figures[0] = new Circle(10, 20, 10, 1);
        figures[1] = new Rectangle(10, 20, 30, 40, 1);
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        figures[2] = new Triangle(point1, point2, point3, 1);
        for (Figure figure : figures)
            figure.setColor(2);
        for (Figure figure : figures)
            assertEquals(2, figure.getColor());
    }

    @Test
    public void testCompareArea() {
        Figure rect = new Rectangle(0, 0, 10, 10, 1);
        Point2D point1 = new Point2D(0, 0);
        Point2D point2 = new Point2D(10, 10);
        Point2D point3 = new Point2D(0, 10);
        Figure triangle = new Triangle(point1, point2, point3, 1);
        assertEquals(rect.getArea() / 2, triangle.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testIsInside1() {
        Figure[] figures = new Figure[3];
        figures[0] = new Circle(0, 0, 10, 1);
        figures[1] = new Rectangle(-10, -20, 10, 20, 1);
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        figures[2] = new Triangle(point1, point2, point3, 1);
        for (Figure figure : figures)
            assertTrue(figure.isInside(0, 0));
    }

    @Test
    public void testIsInside2() {
        Figure[] figures = new Figure[3];
        figures[0] = new Circle(0, 0, 10, 1);
        figures[1] = new Rectangle(-10, -20, 10, 20, 1);
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        figures[2] = new Triangle(point1, point2, point3, 1);
        for (Figure figure : figures)
            assertTrue(figure.isInside(new Point2D(0, 0)));
    }

    @Test
    public void testMoveRel() {
        Rectangle rect = new Rectangle(0, 0, 10, 10, 1);
        Figure figure = rect;
        figure.moveRel(10, 10);
        assertAll(
                () -> assertEquals(10, rect.getTopLeft().getX()),
                () -> assertEquals(10, rect.getTopLeft().getY()),
                () -> assertEquals(20, rect.getBottomRight().getX()),
                () -> assertEquals(20, rect.getBottomRight().getY())
        );

    }
}
