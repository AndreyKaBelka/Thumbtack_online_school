package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorErrorCode;
import net.thumbtack.school.colors.ColorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTriangle {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testTriangle1A() throws ColorException {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle = new Triangle(point1, point2, point3, Color.BLUE);
        assertAll(
                () -> assertEquals(2, triangle.getPoint1().getX()),
                () -> assertEquals(0, triangle.getPoint1().getY()),
                () -> assertEquals(-1, triangle.getPoint2().getX()),
                () -> assertEquals(0, triangle.getPoint2().getY()),
                () -> assertEquals(0, triangle.getPoint3().getX()),
                () -> assertEquals(2, triangle.getPoint3().getY()),
                () -> assertEquals(Color.BLUE, triangle.getColor())
        );
    }

    @Test
    public void testTriangle1B() throws ColorException {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle = new Triangle(point1, point2, point3, "BLUE");
        assertAll(
                () -> assertEquals(2, triangle.getPoint1().getX()),
                () -> assertEquals(0, triangle.getPoint1().getY()),
                () -> assertEquals(-1, triangle.getPoint2().getX()),
                () -> assertEquals(0, triangle.getPoint2().getY()),
                () -> assertEquals(0, triangle.getPoint3().getX()),
                () -> assertEquals(2, triangle.getPoint3().getY()),
                () -> assertEquals(Color.BLUE, triangle.getColor())
        );
    }


    @Test
    @SuppressWarnings("unused")
    public void testTriangleWrongColor() {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        try {
            Triangle triangle = new Triangle(point1, point2, point3, "YELLOW");
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.WRONG_COLOR_STRING, ex.getErrorCode());
        }
        try {
            Triangle triangle = new Triangle(point1, point2, point3, (String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Triangle triangle = new Triangle(point1, point2, point3, (Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Triangle triangle = new Triangle(point1, point2, point3, "BLUE");
            triangle.setColor((Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Triangle triangle = new Triangle(point1, point2, point3, "BLUE");
            triangle.setColor((String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
    }

    @Test
    public void testSetPointTriangle() throws ColorException {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle = new Triangle(point1, point2, point3, Color.BLUE);
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
    public void testMoveRelTriangle() throws ColorException {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle = new Triangle(point1, point2, point3, Color.BLUE);
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
    public void testChangeColorTriangle1() throws ColorException {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle = new Triangle(point1, point2, point3, Color.BLUE);
        triangle.setColor(Color.GREEN);
        assertEquals(Color.GREEN, triangle.getColor());
    }

    @Test
    public void testChangeColorTriangle2() throws ColorException {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle = new Triangle(point1, point2, point3, Color.BLUE);
        triangle.setColor("GREEN");
        assertEquals(Color.GREEN, triangle.getColor());
    }

    @Test
    public void testAreaTriangle() throws ColorException {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle = new Triangle(point1, point2, point3, Color.BLUE);
        assertEquals(3.0, triangle.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testPerimeterTriangle() throws ColorException {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle = new Triangle(point1, point2, point3, Color.BLUE);
        assertEquals(8.06449510, triangle.getPerimeter(), DOUBLE_EPS);
    }

    @Test
    public void testIsPointInsideTriangle1() throws ColorException {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle = new Triangle(point1, point2, point3, Color.BLUE);
        assertAll(
                () -> assertTrue(triangle.isInside(0, 0)),
                () -> assertTrue(triangle.isInside(0, 2)),
                () -> assertFalse(triangle.isInside(10, 0)),
                () -> assertFalse(triangle.isInside(0, 10)),
                () -> assertFalse(triangle.isInside(10, 10))
        );
    }

    @Test
    public void testIsPointInsideTriangle2() throws ColorException {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle = new Triangle(point1, point2, point3, Color.BLUE);
        assertAll(
                () -> assertTrue(triangle.isInside(0, 0)),
                () -> assertTrue(triangle.isInside(0, 2)),
                () -> assertFalse(triangle.isInside(10, 0)),
                () -> assertFalse(triangle.isInside(0, 10)),
                () -> assertFalse(triangle.isInside(10, 10))
        );
    }

    @Test
    public void testEqualsTriangle() throws ColorException {
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        Triangle triangle1 = new Triangle(point1, point2, point3, Color.BLUE);
        Triangle triangle2 = new Triangle(point1, point2, point3, Color.BLUE);
        Triangle triangle3 = new Triangle(point2, point1, point3, Color.BLUE);
        Triangle triangle4 = new Triangle(point1, point3, point2, Color.BLUE);
        Triangle triangle5 = new Triangle(point1, point2, point3, Color.GREEN);
        assertEquals(triangle1, triangle2);
        assertNotEquals(triangle1, triangle3);
        assertNotEquals(triangle1, triangle4);
        assertNotEquals(triangle1, triangle5);
    }

}
