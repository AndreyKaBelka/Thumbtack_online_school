package net.thumbtack.school.figures.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRectangle {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testRectangle1() {
        Point2D topLeft = new Point2D(10, 20);
        Point2D bottomRight = new Point2D(30, 40);
        Rectangle rect = new Rectangle(topLeft, bottomRight, 1);
        assertAll(
                () -> assertEquals(10, rect.getTopLeft().getX()),
                () -> assertEquals(20, rect.getTopLeft().getY()),
                () -> assertEquals(30, rect.getBottomRight().getX()),
                () -> assertEquals(40, rect.getBottomRight().getY()),
                () -> assertEquals(20, rect.getLength()),
                () -> assertEquals(20, rect.getWidth()),
                () -> assertEquals(1, rect.getColor())
        );
    }

    @Test
    public void testRectangle2() {
        Rectangle rect = new Rectangle(10, 20, 30, 40, 1);
        assertAll(
                () -> assertEquals(10, rect.getTopLeft().getX()),
                () -> assertEquals(20, rect.getTopLeft().getY()),
                () -> assertEquals(30, rect.getBottomRight().getX()),
                () -> assertEquals(40, rect.getBottomRight().getY()),
                () -> assertEquals(20, rect.getLength()),
                () -> assertEquals(20, rect.getWidth()),
                () -> assertEquals(1, rect.getColor())
        );
    }

    @Test
    public void testRectangle3() {
        Rectangle rect = new Rectangle(10, 20, 1);
        assertAll(
                () -> assertEquals(0, rect.getTopLeft().getX()),
                () -> assertEquals(-20, rect.getTopLeft().getY()),
                () -> assertEquals(10, rect.getBottomRight().getX()),
                () -> assertEquals(0, rect.getBottomRight().getY()),
                () -> assertEquals(10, rect.getLength()),
                () -> assertEquals(20, rect.getWidth()),
                () -> assertEquals(1, rect.getColor())
        );
    }

    @Test
    public void testRectangle4() {
        Rectangle rect = new Rectangle(1);
        assertAll(
                () -> assertEquals(0, rect.getTopLeft().getX()),
                () -> assertEquals(-1, rect.getTopLeft().getY()),
                () -> assertEquals(1, rect.getBottomRight().getX()),
                () -> assertEquals(0, rect.getBottomRight().getY()),
                () -> assertEquals(1, rect.getLength()),
                () -> assertEquals(1, rect.getWidth()),
                () -> assertEquals(1, rect.getColor())
        );
    }

    @Test
    public void testMoveRelRectangle() {
        Rectangle rect = new Rectangle(10, 20, 30, 40, 1);
        rect.moveRel(100, 50);
        assertAll(
                () -> assertEquals(110, rect.getTopLeft().getX()),
                () -> assertEquals(70, rect.getTopLeft().getY()),
                () -> assertEquals(130, rect.getBottomRight().getX()),
                () -> assertEquals(90, rect.getBottomRight().getY()),
                () -> assertEquals(1, rect.getColor())
        );
    }

    @Test
    public void testChangeColorRectangle() {
        Rectangle rect = new Rectangle(10, 20, 30, 40, 1);
        rect.setColor(2);
        assertEquals(2, rect.getColor());
    }

    @Test
    public void testEnlargeRectangle() {
        Rectangle rect = new Rectangle(10, 20, 30, 40, 1);
        rect.enlarge(3, 5);
        assertAll(
                () -> assertEquals(10, rect.getTopLeft().getX()),
                () -> assertEquals(20, rect.getTopLeft().getY()),
                () -> assertEquals(70, rect.getBottomRight().getX()),
                () -> assertEquals(120, rect.getBottomRight().getY()),
                () -> assertEquals(1, rect.getColor())
        );
    }

    @Test
    public void testIsPointInsideRectangle1() {
        Rectangle rect = new Rectangle(10, 20, 30, 40, 1);
        assertAll(
                () -> assertTrue(rect.isInside(20, 30)),
                () -> assertTrue(rect.isInside(10, 30)),
                () -> assertTrue(rect.isInside(30, 30)),
                () -> assertTrue(rect.isInside(10, 40)),
                () -> assertFalse(rect.isInside(0, 0)),
                () -> assertFalse(rect.isInside(10, 100)),
                () -> assertFalse(rect.isInside(-10, 20)),
                () -> assertFalse(rect.isInside(10, -20))
        );
    }

    @Test
    public void testIsPointInsideRectangle2() {
        Rectangle rect = new Rectangle(10, 20, 30, 40, 1);
        assertAll(
                () -> assertTrue(rect.isInside(20, 30)),
                () -> assertTrue(rect.isInside(10, 30)),
                () -> assertTrue(rect.isInside(30, 30)),
                () -> assertTrue(rect.isInside(10, 40)),
                () -> assertFalse(rect.isInside(0, 0)),
                () -> assertFalse(rect.isInside(10, 100)),
                () -> assertFalse(rect.isInside(-10, 20)),
                () -> assertFalse(rect.isInside(10, -20))
        );
    }

    @Test
    public void testIsIntersectsRectangle() {
        Rectangle rect = new Rectangle(10, 20, 30, 40, 1);
        assertAll(
                () -> assertTrue(rect.isIntersects(new Rectangle(15, 25, 25, 35, 1))),
                () -> assertTrue(rect.isIntersects(new Rectangle(-10, 20, 30, 40, 1))),
                () -> assertTrue(rect.isIntersects(new Rectangle(10, 20, 50, 40, 1))),
                () -> assertTrue(rect.isIntersects(new Rectangle(-10, 20, 50, 40, 1))),
                () -> assertTrue(rect.isIntersects(new Rectangle(10, -20, 30, 40, 1))),
                () -> assertTrue(rect.isIntersects(new Rectangle(10, 20, 30, 60, 1))),
                () -> assertTrue(rect.isIntersects(new Rectangle(-10, -20, 50, 60, 1))),
                () -> assertTrue(rect.isIntersects(new Rectangle(0, 10, 20, 30, 1))),
                () -> assertTrue(rect.isIntersects(new Rectangle(20, 30, 40, 50, 1))),
                () -> assertFalse(rect.isIntersects(new Rectangle(-40, 20, -30, 40, 1))),
                () -> assertFalse(rect.isIntersects(new Rectangle(110, 120, 130, 140, 1))),
                () -> assertFalse(rect.isIntersects(new Rectangle(10, 120, 30, 140, 1))),
                () -> assertFalse(rect.isIntersects(new Rectangle(10, -40, 30, -20, 1)))
        );
    }

    @Test
    public void testIsRectangleInsideRectangle() {
        Rectangle rect = new Rectangle(10, 20, 30, 40, 1);
        assertAll(
                () -> assertTrue(rect.isInside(new Rectangle(15, 25, 25, 35, 1))),
                () -> assertFalse(rect.isInside(new Rectangle(-40, 20, -30, 40, 1))),
                () -> assertFalse(rect.isInside(new Rectangle(110, 120, 130, 140, 1))),
                () -> assertFalse(rect.isInside(new Rectangle(10, 120, 30, 140, 1))),
                () -> assertFalse(rect.isInside(new Rectangle(10, -40, 30, -20, 1)))
        );
    }

    @Test
    public void testEqualsRectangle() {
        Rectangle rect1 = new Rectangle(10, 20, 30, 40, 1);
        Rectangle rect2 = new Rectangle(10, 20, 30, 40, 1);
        Rectangle rect3 = new Rectangle(20, 30, 40, 50, 1);
        Rectangle rect4 = new Rectangle(10, 20, 30, 40, 2);
        assertEquals(rect1, rect2);
        assertNotEquals(rect1, rect3);
        assertNotEquals(rect1, rect4);
    }

    @Test
    public void testAreaRectangle() {
        Rectangle rect1 = new Rectangle(10, 20, 30, 40, 1);
        Rectangle rect2 = new Rectangle(20, 30, 40, 80, 1);
        assertEquals(400, rect1.getArea(), DOUBLE_EPS);
        assertEquals(1000, rect2.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testPerimeterRectangle() {
        Rectangle rect1 = new Rectangle(10, 20, 30, 40, 1);
        Rectangle rect2 = new Rectangle(20, 30, 40, 80, 1);
        assertEquals(80, rect1.getPerimeter(), DOUBLE_EPS);
        assertEquals(140, rect2.getPerimeter(), DOUBLE_EPS);
    }

}
