package net.thumbtack.school.figures.v3;


import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorErrorCode;
import net.thumbtack.school.colors.ColorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRectangle {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testRectangle1A() throws ColorException {
        Point2D topLeft = new Point2D(10, 20);
        Point2D bottomRight = new Point2D(30, 40);
        Rectangle rect = new Rectangle(topLeft, bottomRight, Color.BLUE);
        assertAll(
                () -> assertEquals(10, rect.getTopLeft().getX()),
                () -> assertEquals(20, rect.getTopLeft().getY()),
                () -> assertEquals(30, rect.getBottomRight().getX()),
                () -> assertEquals(40, rect.getBottomRight().getY()),
                () -> assertEquals(20, rect.getLength()),
                () -> assertEquals(20, rect.getWidth()),
                () -> assertEquals(Color.BLUE, rect.getColor())
        );
    }

    @Test
    public void testRectangle1B() throws ColorException {
        Point2D topLeft = new Point2D(10, 20);
        Point2D bottomRight = new Point2D(30, 40);
        Rectangle rect = new Rectangle(topLeft, bottomRight, "BLUE");
        assertAll(
                () -> assertEquals(10, rect.getTopLeft().getX()),
                () -> assertEquals(20, rect.getTopLeft().getY()),
                () -> assertEquals(30, rect.getBottomRight().getX()),
                () -> assertEquals(40, rect.getBottomRight().getY()),
                () -> assertEquals(20, rect.getLength()),
                () -> assertEquals(20, rect.getWidth()),
                () -> assertEquals(Color.BLUE, rect.getColor())
        );
    }

    @Test
    public void testRectangle2A() throws ColorException {
        Rectangle rect = new Rectangle(10, 20, 30, 40, Color.BLUE);
        assertAll(
                () -> assertEquals(10, rect.getTopLeft().getX()),
                () -> assertEquals(20, rect.getTopLeft().getY()),
                () -> assertEquals(30, rect.getBottomRight().getX()),
                () -> assertEquals(40, rect.getBottomRight().getY()),
                () -> assertEquals(20, rect.getLength()),
                () -> assertEquals(20, rect.getWidth()),
                () -> assertEquals(Color.BLUE, rect.getColor())
        );
    }

    @Test
    public void testRectangle2B() throws ColorException {
        Rectangle rect = new Rectangle(10, 20, 30, 40, "BLUE");
        assertAll(
                () -> assertEquals(10, rect.getTopLeft().getX()),
                () -> assertEquals(20, rect.getTopLeft().getY()),
                () -> assertEquals(30, rect.getBottomRight().getX()),
                () -> assertEquals(40, rect.getBottomRight().getY()),
                () -> assertEquals(20, rect.getLength()),
                () -> assertEquals(20, rect.getWidth()),
                () -> assertEquals(Color.BLUE, rect.getColor())
        );
    }

    @Test
    public void testRectangle3A() throws ColorException {
        Rectangle rect = new Rectangle(10, 20, Color.BLUE);
        assertAll(
                () -> assertEquals(0, rect.getTopLeft().getX()),
                () -> assertEquals(-20, rect.getTopLeft().getY()),
                () -> assertEquals(10, rect.getBottomRight().getX()),
                () -> assertEquals(0, rect.getBottomRight().getY()),
                () -> assertEquals(10, rect.getLength()),
                () -> assertEquals(20, rect.getWidth()),
                () -> assertEquals(Color.BLUE, rect.getColor())
        );
    }

    @Test
    public void testRectangle3B() throws ColorException {
        Rectangle rect = new Rectangle(10, 20, "BLUE");
        assertAll(
                () -> assertEquals(0, rect.getTopLeft().getX()),
                () -> assertEquals(-20, rect.getTopLeft().getY()),
                () -> assertEquals(10, rect.getBottomRight().getX()),
                () -> assertEquals(0, rect.getBottomRight().getY()),
                () -> assertEquals(10, rect.getLength()),
                () -> assertEquals(20, rect.getWidth()),
                () -> assertEquals(Color.BLUE, rect.getColor())
        );
    }

    @Test
    public void testRectangle4A() throws ColorException {
        Rectangle rect = new Rectangle(Color.BLUE);
        assertAll(
                () -> assertEquals(0, rect.getTopLeft().getX()),
                () -> assertEquals(-1, rect.getTopLeft().getY()),
                () -> assertEquals(1, rect.getBottomRight().getX()),
                () -> assertEquals(0, rect.getBottomRight().getY()),
                () -> assertEquals(1, rect.getLength()),
                () -> assertEquals(1, rect.getWidth()),
                () -> assertEquals(Color.BLUE, rect.getColor())
        );
    }

    @Test
    public void testRectangle4B() throws ColorException {
        Rectangle rect = new Rectangle("BLUE");
        assertAll(
                () -> assertEquals(0, rect.getTopLeft().getX()),
                () -> assertEquals(-1, rect.getTopLeft().getY()),
                () -> assertEquals(1, rect.getBottomRight().getX()),
                () -> assertEquals(0, rect.getBottomRight().getY()),
                () -> assertEquals(1, rect.getLength()),
                () -> assertEquals(1, rect.getWidth()),
                () -> assertEquals(Color.BLUE, rect.getColor())
        );
    }

    @Test
    @SuppressWarnings("unused")
    public void testRectangleWrongColor() {
        try {
            Rectangle rect = new Rectangle(10, 20, "YELLOW");
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.WRONG_COLOR_STRING, ex.getErrorCode());
        }
        try {
            Rectangle rect = new Rectangle(10, 20, (String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Rectangle rect = new Rectangle(10, 20, (Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Rectangle rect = new Rectangle(10, 20, "BLUE");
            rect.setColor((Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Rectangle rect = new Rectangle(10, 20, "BLUE");
            rect.setColor((String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
    }

    @Test
    public void testMoveRelRectangle() throws ColorException {
        Rectangle rect = new Rectangle(10, 20, 30, 40, Color.BLUE);
        rect.moveRel(100, 50);
        assertAll(
                () -> assertEquals(110, rect.getTopLeft().getX()),
                () -> assertEquals(70, rect.getTopLeft().getY()),
                () -> assertEquals(130, rect.getBottomRight().getX()),
                () -> assertEquals(90, rect.getBottomRight().getY()),
                () -> assertEquals(Color.BLUE, rect.getColor())
        );
    }

    @Test
    public void testChangeColorRectangle1() throws ColorException {
        Rectangle rect = new Rectangle(10, 20, 30, 40, Color.BLUE);
        rect.setColor(Color.GREEN);
        assertEquals(Color.GREEN, rect.getColor());
    }

    @Test
    public void testChangeColorRectangle2() throws ColorException {
        Rectangle rect = new Rectangle(10, 20, 30, 40, Color.BLUE);
        rect.setColor("GREEN");
        assertEquals(Color.GREEN, rect.getColor());
    }

    @Test
    public void testEnlargeRectangle() throws ColorException {
        Rectangle rect = new Rectangle(10, 20, 30, 40, Color.BLUE);
        rect.enlarge(3, 5);
        assertAll(
                () -> assertEquals(10, rect.getTopLeft().getX()),
                () -> assertEquals(20, rect.getTopLeft().getY()),
                () -> assertEquals(70, rect.getBottomRight().getX()),
                () -> assertEquals(120, rect.getBottomRight().getY()),
                () -> assertEquals(Color.BLUE, rect.getColor())
        );
    }

    @Test
    public void testIsPointInsideRectangle1() throws ColorException {
        Rectangle rect = new Rectangle(10, 20, 30, 40, Color.BLUE);
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
    public void testIsPointInsideRectangle2() throws ColorException {
        Rectangle rect = new Rectangle(10, 20, 30, 40, Color.BLUE);
        assertAll(
                () -> assertTrue(rect.isInside(new Point2D(20, 30))),
                () -> assertTrue(rect.isInside(new Point2D(10, 30))),
                () -> assertTrue(rect.isInside(new Point2D(30, 30))),
                () -> assertTrue(rect.isInside(new Point2D(10, 40))),
                () -> assertFalse(rect.isInside(new Point2D(0, 0))),
                () -> assertFalse(rect.isInside(new Point2D(10, 100))),
                () -> assertFalse(rect.isInside(new Point2D(-10, 20))),
                () -> assertFalse(rect.isInside(new Point2D(10, -20)))
        );

    }

    @Test
    public void testIsIntersectsRectangle() throws ColorException {
        Rectangle rect = new Rectangle(10, 20, 30, 40, Color.BLUE);
        assertAll(
                () -> assertTrue(rect.isIntersects(new Rectangle(15, 25, 25, 35, Color.BLUE))),
                () -> assertTrue(rect.isIntersects(new Rectangle(-10, 20, 30, 40, Color.BLUE))),
                () -> assertTrue(rect.isIntersects(new Rectangle(10, 20, 50, 40, Color.BLUE))),
                () -> assertTrue(rect.isIntersects(new Rectangle(-10, 20, 50, 40, Color.BLUE))),
                () -> assertTrue(rect.isIntersects(new Rectangle(10, -20, 30, 40, Color.BLUE))),
                () -> assertTrue(rect.isIntersects(new Rectangle(10, 20, 30, 60, Color.BLUE))),
                () -> assertTrue(rect.isIntersects(new Rectangle(-10, -20, 50, 60, Color.BLUE))),
                () -> assertTrue(rect.isIntersects(new Rectangle(0, 10, 20, 30, Color.BLUE))),
                () -> assertTrue(rect.isIntersects(new Rectangle(20, 30, 40, 50, Color.BLUE))),
                () -> assertFalse(rect.isIntersects(new Rectangle(-40, 20, -30, 40, Color.BLUE))),
                () -> assertFalse(rect.isIntersects(new Rectangle(110, 120, 130, 140, Color.BLUE))),
                () -> assertFalse(rect.isIntersects(new Rectangle(10, 120, 30, 140, Color.BLUE))),
                () -> assertFalse(rect.isIntersects(new Rectangle(10, -40, 30, -20, Color.BLUE)))
        );
    }

    @Test
    public void testIsRectangleInsideRectangle() throws ColorException {
        Rectangle rect = new Rectangle(10, 20, 30, 40, Color.BLUE);
        assertAll(
                () -> assertTrue(rect.isInside(new Rectangle(15, 25, 25, 35, Color.BLUE))),
                () -> assertFalse(rect.isInside(new Rectangle(-40, 20, -30, 40, Color.BLUE))),
                () -> assertFalse(rect.isInside(new Rectangle(110, 120, 130, 140, Color.BLUE))),
                () -> assertFalse(rect.isInside(new Rectangle(10, 120, 30, 140, Color.BLUE))),
                () -> assertFalse(rect.isInside(new Rectangle(10, -40, 30, -20, Color.BLUE)))
        );
    }

    @Test
    public void testEqualsRectangle() throws ColorException {
        Rectangle rect1 = new Rectangle(10, 20, 30, 40, Color.BLUE);
        Rectangle rect2 = new Rectangle(10, 20, 30, 40, Color.BLUE);
        Rectangle rect3 = new Rectangle(20, 30, 40, 50, Color.BLUE);
        Rectangle rect5 = new Rectangle(10, 20, 30, 40, Color.GREEN);
        assertEquals(rect1, rect2);
        assertNotEquals(rect1, rect3);
        assertNotEquals(rect1, rect5);
    }

    @Test
    public void testAreaRectangle() throws ColorException {
        Rectangle rect1 = new Rectangle(10, 20, 30, 40, Color.BLUE);
        Rectangle rect2 = new Rectangle(20, 30, 40, 80, Color.BLUE);
        assertEquals(400, rect1.getArea(), DOUBLE_EPS);
        assertEquals(1000, rect2.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testPerimeterRectangle() throws ColorException {
        Rectangle rect1 = new Rectangle(10, 20, 30, 40, Color.BLUE);
        Rectangle rect2 = new Rectangle(20, 30, 40, 80, Color.BLUE);
        assertEquals(80, rect1.getPerimeter(), DOUBLE_EPS);
        assertEquals(140, rect2.getPerimeter(), DOUBLE_EPS);
    }

}
