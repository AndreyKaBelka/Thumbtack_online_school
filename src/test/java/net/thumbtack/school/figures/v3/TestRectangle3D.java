package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorErrorCode;
import net.thumbtack.school.colors.ColorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRectangle3D {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testRectangle3D1A() throws ColorException {
        Point2D topLeft = new Point2D(10, 20);
        Point2D bottomRight = new Point2D(30, 40);
        Rectangle3D rect3D = new Rectangle3D(topLeft, bottomRight, 10, Color.BLUE);
        assertAll(
                () -> assertEquals(10, rect3D.getTopLeft().getX()),
                () -> assertEquals(20, rect3D.getTopLeft().getY()),
                () -> assertEquals(30, rect3D.getBottomRight().getX()),
                () -> assertEquals(40, rect3D.getBottomRight().getY()),
                () -> assertEquals(20, rect3D.getLength()),
                () -> assertEquals(20, rect3D.getWidth()),
                () -> assertEquals(10, rect3D.getHeight()),
                () -> assertEquals(Color.BLUE, rect3D.getColor())
        );
    }

    @Test
    public void testRectangle3D1B() throws ColorException {
        Point2D topLeft = new Point2D(10, 20);
        Point2D bottomRight = new Point2D(30, 40);
        Rectangle3D rect3D = new Rectangle3D(topLeft, bottomRight, 10, "BLUE");
        assertAll(
                () -> assertEquals(10, rect3D.getTopLeft().getX()),
                () -> assertEquals(20, rect3D.getTopLeft().getY()),
                () -> assertEquals(30, rect3D.getBottomRight().getX()),
                () -> assertEquals(40, rect3D.getBottomRight().getY()),
                () -> assertEquals(20, rect3D.getLength()),
                () -> assertEquals(20, rect3D.getWidth()),
                () -> assertEquals(10, rect3D.getHeight()),
                () -> assertEquals(Color.BLUE, rect3D.getColor())
        );
    }


    @Test
    public void testRectangle3D2A() throws ColorException {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, Color.BLUE);
        assertAll(
                () -> assertEquals(10, rect3D.getTopLeft().getX()),
                () -> assertEquals(20, rect3D.getTopLeft().getY()),
                () -> assertEquals(30, rect3D.getBottomRight().getX()),
                () -> assertEquals(40, rect3D.getBottomRight().getY()),
                () -> assertEquals(20, rect3D.getLength()),
                () -> assertEquals(20, rect3D.getWidth()),
                () -> assertEquals(10, rect3D.getHeight()),
                () -> assertEquals(Color.BLUE, rect3D.getColor())
        );
    }

    @Test
    public void testRectangle3D2B() throws ColorException {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, "BLUE");
        assertAll(
                () -> assertEquals(10, rect3D.getTopLeft().getX()),
                () -> assertEquals(20, rect3D.getTopLeft().getY()),
                () -> assertEquals(30, rect3D.getBottomRight().getX()),
                () -> assertEquals(40, rect3D.getBottomRight().getY()),
                () -> assertEquals(20, rect3D.getLength()),
                () -> assertEquals(20, rect3D.getWidth()),
                () -> assertEquals(10, rect3D.getHeight()),
                () -> assertEquals(Color.BLUE, rect3D.getColor())
        );
    }


    @Test
    public void testRectangle3D3A() throws ColorException {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 10, Color.BLUE);
        assertAll(
                () -> assertEquals(0, rect3D.getTopLeft().getX()),
                () -> assertEquals(-20, rect3D.getTopLeft().getY()),
                () -> assertEquals(10, rect3D.getBottomRight().getX()),
                () -> assertEquals(0, rect3D.getBottomRight().getY()),
                () -> assertEquals(10, rect3D.getLength()),
                () -> assertEquals(20, rect3D.getWidth()),
                () -> assertEquals(10, rect3D.getHeight()),
                () -> assertEquals(Color.BLUE, rect3D.getColor())
        );
    }

    @Test
    public void testRectangle3D3B() throws ColorException {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 10, "BLUE");
        assertAll(
                () -> assertEquals(0, rect3D.getTopLeft().getX()),
                () -> assertEquals(-20, rect3D.getTopLeft().getY()),
                () -> assertEquals(10, rect3D.getBottomRight().getX()),
                () -> assertEquals(0, rect3D.getBottomRight().getY()),
                () -> assertEquals(10, rect3D.getLength()),
                () -> assertEquals(20, rect3D.getWidth()),
                () -> assertEquals(10, rect3D.getHeight()),
                () -> assertEquals(Color.BLUE, rect3D.getColor())
        );
    }


    @Test
    public void testRectangle3D4A() throws ColorException {
        Rectangle3D rect3D = new Rectangle3D(Color.BLUE);
        assertAll(
                () -> assertEquals(0, rect3D.getTopLeft().getX()),
                () -> assertEquals(-1, rect3D.getTopLeft().getY()),
                () -> assertEquals(1, rect3D.getBottomRight().getX()),
                () -> assertEquals(0, rect3D.getBottomRight().getY()),
                () -> assertEquals(1, rect3D.getLength()),
                () -> assertEquals(1, rect3D.getWidth()),
                () -> assertEquals(1, rect3D.getHeight()),
                () -> assertEquals(Color.BLUE, rect3D.getColor())
        );
    }

    @Test
    public void testRectangle3D4B() throws ColorException {
        Rectangle3D rect3D = new Rectangle3D("BLUE");
        assertAll(
                () -> assertEquals(0, rect3D.getTopLeft().getX()),
                () -> assertEquals(-1, rect3D.getTopLeft().getY()),
                () -> assertEquals(1, rect3D.getBottomRight().getX()),
                () -> assertEquals(0, rect3D.getBottomRight().getY()),
                () -> assertEquals(1, rect3D.getLength()),
                () -> assertEquals(1, rect3D.getWidth()),
                () -> assertEquals(1, rect3D.getHeight()),
                () -> assertEquals(Color.BLUE, rect3D.getColor())
        );
    }

    @Test
    @SuppressWarnings("unused")
    public void testRectangle3DWrongColor() {
        try {
            Rectangle3D rect3D = new Rectangle3D(10, 20, 10, "YELLOW");
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.WRONG_COLOR_STRING, ex.getErrorCode());
        }
        try {
            Rectangle3D rect3D = new Rectangle3D(10, 20, 10, (String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Rectangle3D rect3D = new Rectangle3D(10, 20, 10, (Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Rectangle3D rect3D = new Rectangle3D(10, 20, 10, "BLUE");
            rect3D.setColor((Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Rectangle3D rect3D = new Rectangle3D(10, 20, 10, "BLUE");
            rect3D.setColor((String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
    }

    @Test
    public void testMoveRelRectangle3D() throws ColorException {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, Color.BLUE);
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
    public void testChangeColorRectangle3D1() throws ColorException {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, Color.BLUE);
        rect3D.setColor(Color.GREEN);
        assertEquals(Color.GREEN, rect3D.getColor());
    }

    @Test
    public void testChangeColorRectangle3D2() throws ColorException {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, Color.BLUE);
        rect3D.setColor("GREEN");
        assertEquals(Color.GREEN, rect3D.getColor());
    }

    @Test
    public void testEnlargeRectangle3D() throws ColorException {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, Color.BLUE);
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
    public void testIsPointInsideRectangle3D1() throws ColorException {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, Color.BLUE);
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
    public void testIsPointInsideRectangle3D2() throws ColorException {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, Color.BLUE);
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
    public void testIsIntersectsRectangle3D() throws ColorException {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, Color.BLUE);
        assertAll(
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(15, 25, 25, 35, 5, Color.BLUE))),
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(-10, 20, 30, 40, 3, Color.BLUE))),
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(10, 20, 50, 40, 10, Color.BLUE))),
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(-10, 20, 50, 40, 100, Color.BLUE))),
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(10, -20, 30, 40, 20, Color.BLUE))),
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(10, 20, 30, 60, 15, Color.BLUE))),
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(-10, -20, 50, 60, 10, Color.BLUE))),
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(0, 10, 20, 30, 10, Color.BLUE))),
                () -> assertTrue(rect3D.isIntersects(new Rectangle3D(20, 30, 40, 50, 15, Color.BLUE))),
                () -> assertFalse(rect3D.isIntersects(new Rectangle3D(-40, 20, -30, 40, 15, Color.BLUE))),
                () -> assertFalse(rect3D.isIntersects(new Rectangle3D(110, 120, 130, 140, 25, Color.BLUE))),
                () -> assertFalse(rect3D.isIntersects(new Rectangle3D(10, 120, 30, 140, 50, Color.BLUE))),
                () -> assertFalse(rect3D.isIntersects(new Rectangle3D(10, -40, 30, -20, 80, Color.BLUE)))
        );
    }

    @Test
    public void testIsRectangleInsideRectangle3D() throws ColorException {
        Rectangle3D rect3D = new Rectangle3D(10, 20, 30, 40, 10, Color.BLUE);
        assertAll(
                () -> assertTrue(rect3D.isInside(new Rectangle3D(15, 25, 25, 35, 10, Color.BLUE))),
                () -> assertFalse(rect3D.isInside(new Rectangle3D(15, 25, 25, 35, 20, Color.BLUE))),
                () -> assertFalse(rect3D.isInside(new Rectangle3D(-40, 20, -30, 40, 20, Color.BLUE))),
                () -> assertFalse(rect3D.isInside(new Rectangle3D(110, 120, 130, 140, 10, Color.BLUE))),
                () -> assertFalse(rect3D.isInside(new Rectangle3D(10, 120, 30, 140, 60, Color.BLUE))),
                () -> assertFalse(rect3D.isInside(new Rectangle3D(10, -40, 30, -20, 40, Color.BLUE)))
        );
    }

    @Test
    public void testEqualsRectangle3D() throws ColorException {
        Rectangle3D rect3D1 = new Rectangle3D(10, 20, 30, 40, 10, Color.BLUE);
        Rectangle3D rect3D2 = new Rectangle3D(10, 20, 30, 40, 10, Color.BLUE);
        Rectangle3D rect3D3 = new Rectangle3D(10, 20, 30, 40, 20, Color.BLUE);
        Rectangle3D rect3D4 = new Rectangle3D(20, 30, 40, 50, 10, Color.BLUE);
        assertEquals(rect3D1, rect3D2);
        assertNotEquals(rect3D1, rect3D3);
        assertNotEquals(rect3D1, rect3D4);
    }

    @Test
    public void testAreaRectangle3D() throws ColorException {
        Rectangle3D rect3D1 = new Rectangle3D(10, 20, 30, 40, 10, Color.BLUE);
        Rectangle3D rect3D2 = new Rectangle3D(20, 30, 40, 80, 10, Color.BLUE);
        assertEquals(400, rect3D1.getArea(), DOUBLE_EPS);
        assertEquals(1000, rect3D2.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testPerimeterRectangle3D() throws ColorException {
        Rectangle3D rect3D1 = new Rectangle3D(10, 20, 30, 40, 10, Color.BLUE);
        Rectangle3D rect3D2 = new Rectangle3D(20, 30, 40, 80, 10, Color.BLUE);
        assertEquals(80, rect3D1.getPerimeter(), DOUBLE_EPS);
        assertEquals(140, rect3D2.getPerimeter(), DOUBLE_EPS);
    }

    @Test
    public void testVolumeRectangle3D() throws ColorException {
        Rectangle3D rect3D1 = new Rectangle3D(10, 20, 30, 40, 10, Color.BLUE);
        Rectangle3D rect3D2 = new Rectangle3D(20, 30, 40, 80, 10, Color.BLUE);
        assertEquals(4000, rect3D1.getVolume(), DOUBLE_EPS);
        assertEquals(10000, rect3D2.getVolume(), DOUBLE_EPS);
    }

}
