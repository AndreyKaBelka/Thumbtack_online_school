package net.thumbtack.school.figures.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRectangle3D {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testRectangle3D1() {
        Point2D topLeft = new Point2D(10, 20);
        Point2D bottomRight = new Point2D(30, 40);
        Rectangle3D rect3D = new Rectangle3D(topLeft, bottomRight, 10, 1);
        assertAll(
                () -> assertEquals(10, rect3D.getTopLeft().getX()),
                () -> assertEquals(20, rect3D.getTopLeft().getY()),
                () -> assertEquals(30, rect3D.getBottomRight().getX()),
                () -> assertEquals(40, rect3D.getBottomRight().getY()),
                () -> assertEquals(20, rect3D.getLength()),
                () -> assertEquals(20, rect3D.getWidth()),
                () -> assertEquals(10, rect3D.getHeight()),
                () -> assertEquals(1, rect3D.getColor())
        );
    }

    @Test
    public void testRectangle3D2() {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, 1);
        assertAll(
                () -> assertEquals(10, rect3D.getTopLeft().getX()),
                () -> assertEquals(20, rect3D.getTopLeft().getY()),
                () -> assertEquals(30, rect3D.getBottomRight().getX()),
                () -> assertEquals(40, rect3D.getBottomRight().getY()),
                () -> assertEquals(20, rect3D.getLength()),
                () -> assertEquals(20, rect3D.getWidth()),
                () -> assertEquals(10, rect3D.getHeight()),
                () -> assertEquals(1, rect3D.getColor())
        );
    }

    @Test
    public void testRectangle3D3() {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 10, 1);
        assertAll(
                () -> assertEquals(0, rect3D.getTopLeft().getX()),
                () -> assertEquals(-20, rect3D.getTopLeft().getY()),
                () -> assertEquals(10, rect3D.getBottomRight().getX()),
                () -> assertEquals(0, rect3D.getBottomRight().getY()),
                () -> assertEquals(10, rect3D.getLength()),
                () -> assertEquals(20, rect3D.getWidth()),
                () -> assertEquals(10, rect3D.getHeight()),
                () -> assertEquals(1, rect3D.getColor())
        );
    }

    @Test
    public void testRectangle3D4() {
        Rectangle3D rect3D = new Rectangle3D(1);
        assertAll(
                () -> assertEquals(0, rect3D.getTopLeft().getX()),
                () -> assertEquals(-1, rect3D.getTopLeft().getY()),
                () -> assertEquals(1, rect3D.getBottomRight().getX()),
                () -> assertEquals(0, rect3D.getBottomRight().getY()),
                () -> assertEquals(1, rect3D.getLength()),
                () -> assertEquals(1, rect3D.getWidth()),
                () -> assertEquals(1, rect3D.getHeight()),
                () -> assertEquals(1, rect3D.getColor())
        );
    }

    @Test
    public void testMoveRelRectangle3D() {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, 1);
        rect3D.moveRel(100, 50);
        assertAll(
                () -> assertEquals(110, rect3D.getTopLeft().getX()),
                () -> assertEquals(70, rect3D.getTopLeft().getY()),
                () -> assertEquals(130, rect3D.getBottomRight().getX()),
                () -> assertEquals(90, rect3D.getBottomRight().getY()),
                () -> assertEquals(10, rect3D.getHeight())
        );
    }

    @Test
    public void testChangeColorRectangle3D() {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, 1);
        rect3D.setColor(2);
        assertEquals(2, rect3D.getColor());
    }

    @Test
    public void testEnlargeRectangle3D() {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, 1);
        rect3D.enlarge(3, 5);
        assertAll(
                () -> assertEquals(10, rect3D.getTopLeft().getX()),
                () -> assertEquals(20, rect3D.getTopLeft().getY()),
                () -> assertEquals(70, rect3D.getBottomRight().getX()),
                () -> assertEquals(120, rect3D.getBottomRight().getY()),
                () -> assertEquals(10, rect3D.getHeight())
        );
    }

    @Test
    public void testIsPointInsideRectangle3D1() {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, 1);
        assertAll(
                () -> assertTrue(rect3D.isInside(20, 30)),
                () -> assertTrue(rect3D.isInside(10, 30)),
                () -> assertTrue(rect3D.isInside(30, 30)),
                () -> assertTrue(rect3D.isInside(10, 40)),
                () -> assertFalse(rect3D.isInside(0, 0)),
                () -> assertFalse(rect3D.isInside(10, 100)),
                () -> assertFalse(rect3D.isInside(-10, 20)),
                () -> assertFalse(rect3D.isInside(10, -20))
        );
    }

    @Test
    public void testIsPointInsideRectangle3D2() {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, 1);
        assertAll(
                () -> assertTrue(rect3D.isInside(new Point2D(20, 30))),
                () -> assertTrue(rect3D.isInside(new Point2D(10, 30))),
                () -> assertTrue(rect3D.isInside(new Point2D(30, 30))),
                () -> assertTrue(rect3D.isInside(new Point2D(10, 40))),
                () -> assertFalse(rect3D.isInside(new Point2D(0, 0))),
                () -> assertFalse(rect3D.isInside(new Point2D(10, 100))),
                () -> assertFalse(rect3D.isInside(new Point2D(-10, 20))),
                () -> assertFalse(rect3D.isInside(new Point2D(10, -20)))
        );
    }

    @Test
    public void testIsIntersectsRectangle3D() {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, 1);
        assertAll(
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(15, 25, 25, 35, 5, 1))),
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(-10, 20, 30, 40, 3, 1))),
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(10, 20, 50, 40, 10, 1))),
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(-10, 20, 50, 40, 100, 1))),
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(10, -20, 30, 40, 20, 1))),
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(10, 20, 30, 60, 15, 1))),
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(-10, -20, 50, 60, 10, 1))),
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(0, 10, 20, 30, 10, 1))),
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(20, 30, 40, 50, 15, 1))),
                () -> assertFalse(rect3D.isIntersects(new Rectangle3D(-40, 20, -30, 40, 15, 1))),
                () -> assertFalse(rect3D.isIntersects(new Rectangle3D(110, 120, 130, 140, 25, 1))),
                () -> assertFalse(rect3D.isIntersects(new Rectangle3D(10, 120, 30, 140, 50, 1))),
                () -> assertFalse(rect3D.isIntersects(new Rectangle3D(10, -40, 30, -20, 80, 1)))
        );
    }

    @Test
    public void testIsRectangleInsideRectangle3D() {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, 1);
        assertAll(
                () -> assertTrue(rect3D.isInside(new Rectangle3D(15, 25, 25, 35, 10, 1))),
                () -> assertFalse(rect3D.isInside(new Rectangle3D(15, 25, 25, 35, 20, 1))),
                () -> assertFalse(rect3D.isInside(new Rectangle3D(-40, 20, -30, 40, 20, 1))),
                () -> assertFalse(rect3D.isInside(new Rectangle3D(110, 120, 130, 140, 10, 1))),
                () -> assertFalse(rect3D.isInside(new Rectangle3D(10, 120, 30, 140, 60, 1))),
                () -> assertFalse(rect3D.isInside(new Rectangle3D(10, -40, 30, -20, 40, 1)))
        );
    }

    @Test
    public void testEqualsRectangle3D() {
        Rectangle3D rect3D1 = new Rectangle3D(10, 20, 30, 40, 10, 1);
        Rectangle3D rect3D2 = new Rectangle3D(10, 20, 30, 40, 10, 1);
        Rectangle3D rect3D3 = new Rectangle3D(10, 20, 30, 40, 20, 1);
        Rectangle3D rect3D4 = new Rectangle3D(20, 30, 40, 50, 10, 1);
        assertEquals(rect3D1, rect3D2);
        assertNotEquals(rect3D1, rect3D3);
        assertNotEquals(rect3D1, rect3D4);
    }

    @Test
    public void testAreaRectangle3D() {
        Rectangle3D rect3D1 = new Rectangle3D(10, 20, 30, 40, 10, 1);
        Rectangle3D rect3D2 = new Rectangle3D(20, 30, 40, 80, 10, 1);
        assertEquals(400, rect3D1.getArea(), DOUBLE_EPS);
        assertEquals(1000, rect3D2.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testPerimeterRectangle3D() {
        Rectangle3D rect3D1 = new Rectangle3D(10, 20, 30, 40, 10, 1);
        Rectangle3D rect3D2 = new Rectangle3D(20, 30, 40, 80, 10, 1);
        assertEquals(80, rect3D1.getPerimeter(), DOUBLE_EPS);
        assertEquals(140, rect3D2.getPerimeter(), DOUBLE_EPS);
    }

    @Test
    public void testVolumeRectangle3D() {
        Rectangle3D rect3D1 = new Rectangle3D(10, 20, 30, 40, 10, 1);
        Rectangle3D rect3D2 = new Rectangle3D(20, 30, 40, 80, 10, 1);
        assertEquals(4000, rect3D1.getVolume(), DOUBLE_EPS);
        assertEquals(10000, rect3D2.getVolume(), DOUBLE_EPS);
    }

}
