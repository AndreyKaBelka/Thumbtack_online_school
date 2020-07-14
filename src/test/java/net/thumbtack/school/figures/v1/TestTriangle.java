package net.thumbtack.school.figures.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTriangle {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testTriangle() {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle = new Triangle(point1, point2, point3);
        assertAll(
                () -> assertEquals(2, triangle.getPoint1().getX()),
                () -> assertEquals(0, triangle.getPoint1().getY()),
                () -> assertEquals(-1, triangle.getPoint2().getX()),
                () -> assertEquals(0, triangle.getPoint2().getY()),
                () -> assertEquals(0, triangle.getPoint3().getX()),
                () -> assertEquals(2, triangle.getPoint3().getY())
        );
    }

    @Test
    public void testSetPointTriangle() {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle = new Triangle(point1, point2, point3);
        triangle.setPoint1(new Point2D(3, 3));
        triangle.setPoint2(new Point2D(10, 20));
        triangle.setPoint3(new Point2D(0, 0));
        assertAll(
                () -> assertEquals(3, triangle.getPoint1().getX()),
                () -> assertEquals(3, triangle.getPoint1().getY()),
                () -> assertEquals(10, triangle.getPoint2().getX()),
                () -> assertEquals(20, triangle.getPoint2().getY()),
                () -> assertEquals(0, triangle.getPoint3().getX()),
                () -> assertEquals(0, triangle.getPoint3().getY())
        );
    }

    @Test
    public void testMoveRelTriangle() {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle = new Triangle(point1, point2, point3);
        triangle.moveRel(10, 20);
        assertAll(
                () -> assertEquals(12, triangle.getPoint1().getX()),
                () -> assertEquals(20, triangle.getPoint1().getY()),
                () -> assertEquals(9, triangle.getPoint2().getX()),
                () -> assertEquals(20, triangle.getPoint2().getY()),
                () -> assertEquals(10, triangle.getPoint3().getX()),
                () -> assertEquals(22, triangle.getPoint3().getY())
        );
    }

    @Test
    public void testAreaTriangle() {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle = new Triangle(point1, point2, point3);
        assertEquals(3.0, triangle.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testPerimeterTriangle() {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle = new Triangle(point1, point2, point3);
        assertEquals(8.06449510, triangle.getPerimeter(), DOUBLE_EPS);
    }

    @Test
    public void testIsPointInsideTriangle1() {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle = new Triangle(point1, point2, point3);
        assertAll(
                () -> assertTrue(triangle.isInside(0, 0)),
                () -> assertTrue(triangle.isInside(0, 2)),
                () -> assertFalse(triangle.isInside(10, 0)),
                () -> assertFalse(triangle.isInside(0, 10)),
                () -> assertFalse(triangle.isInside(10, 10))
        );
    }

    @Test
    public void testIsPointInsideTriangle2() {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle = new Triangle(point1, point2, point3);
        assertAll(
                () -> assertTrue(triangle.isInside(new Point2D(0, 0))),
                () -> assertTrue(triangle.isInside(new Point2D(0, 2))),
                () -> assertFalse(triangle.isInside(new Point2D(10, 0))),
                () -> assertFalse(triangle.isInside(new Point2D(0, 10))),
                () -> assertFalse(triangle.isInside(new Point2D(10, 10)))
        );
    }

    @Test
    public void testEqualsTriangle() {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle1 = new Triangle(point1, point2, point3);
        Triangle triangle2 = new Triangle(point1, point2, point3);
        Triangle triangle3 = new Triangle(point2, point1, point3);
        Triangle triangle4 = new Triangle(point1, point3, point2);
        assertEquals(triangle1, triangle2);
        assertNotEquals(triangle1, triangle3);
        assertNotEquals(triangle1, triangle4);
    }

}
