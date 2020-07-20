package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorErrorCode;
import net.thumbtack.school.colors.ColorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCircle {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testCircle1A() throws ColorException {
        Point2D center = new Point2D(10, 20);
        Circle circle = new Circle(center, 10, Color.BLUE);
        assertAll(
                () -> assertEquals(10, circle.getCenter().getX()),
                () -> assertEquals(20, circle.getCenter().getY()),
                () -> assertEquals(10, circle.getRadius()),
                () -> assertEquals(Color.BLUE, circle.getColor())
        );
    }

    @Test
    public void testCircle1B() throws ColorException {
        Point2D center = new Point2D(10, 20);
        Circle circle = new Circle(center, 10, "BLUE");
        assertAll(
                () -> assertEquals(10, circle.getCenter().getX()),
                () -> assertEquals(20, circle.getCenter().getY()),
                () -> assertEquals(10, circle.getRadius()),
                () -> assertEquals(Color.BLUE, circle.getColor())
        );
    }


    @Test
    public void testCircle2A() throws ColorException {
        Circle circle = new Circle(10, 20, 10, Color.BLUE);
        assertAll(
                () -> assertEquals(10, circle.getCenter().getX()),
                () -> assertEquals(20, circle.getCenter().getY()),
                () -> assertEquals(10, circle.getRadius()),
                () -> assertEquals(Color.BLUE, circle.getColor())
        );
    }

    @Test
    public void testCircle2B() throws ColorException {
        Circle circle = new Circle(10, 20, 10, "BLUE");
        assertAll(
                () -> assertEquals(10, circle.getCenter().getX()),
                () -> assertEquals(20, circle.getCenter().getY()),
                () -> assertEquals(10, circle.getRadius()),
                () -> assertEquals(Color.BLUE, circle.getColor())
        );
    }


    @Test
    public void testCircle3A() throws ColorException {
        Circle circle = new Circle(10, Color.BLUE);
        assertAll(
                () -> assertEquals(0, circle.getCenter().getX()),
                () -> assertEquals(0, circle.getCenter().getY()),
                () -> assertEquals(10, circle.getRadius()),
                () -> assertEquals(Color.BLUE, circle.getColor())
        );
    }

    @Test
    public void testCircle3B() throws ColorException {
        Circle circle = new Circle(10, "BLUE");
        assertAll(
                () -> assertEquals(0, circle.getCenter().getX()),
                () -> assertEquals(0, circle.getCenter().getY()),
                () -> assertEquals(10, circle.getRadius()),
                () -> assertEquals(Color.BLUE, circle.getColor())
        );
    }

    @Test
    public void testCircle4A() throws ColorException {
        Circle circle = new Circle(Color.BLUE);
        assertAll(
                () -> assertEquals(0, circle.getCenter().getX()),
                () -> assertEquals(0, circle.getCenter().getY()),
                () -> assertEquals(1, circle.getRadius()),
                () -> assertEquals(Color.BLUE, circle.getColor())
        );
    }

    @Test
    public void testCircle4B() throws ColorException {
        Circle circle = new Circle("BLUE");
        assertAll(
                () -> assertEquals(0, circle.getCenter().getX()),
                () -> assertEquals(0, circle.getCenter().getY()),
                () -> assertEquals(1, circle.getRadius()),
                () -> assertEquals(Color.BLUE, circle.getColor())
        );
    }

    @Test
    @SuppressWarnings("unused")
    public void testCircleWrongColor() {
        try {
            Circle circle = new Circle(10, 20, 10, "YELLOW");
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.WRONG_COLOR_STRING, ex.getErrorCode());
        }
        try {
            Circle circle = new Circle(10, 20, 10, (String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Circle circle = new Circle(10, 20, 10, (Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Circle circle = new Circle(10, 20, 10, "BLUE");
            circle.setColor((Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Circle circle = new Circle(10, 20, 10, "BLUE");
            circle.setColor((String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
    }


    @Test
    public void testMoveRelCircle() throws ColorException {
        Circle circle = new Circle(10, 20, 10, Color.BLUE);
        circle.moveRel(100, 50);
        assertAll(
                () -> assertEquals(110, circle.getCenter().getX()),
                () -> assertEquals(70, circle.getCenter().getY()),
                () -> assertEquals(10, circle.getRadius()),
                () -> assertEquals(Color.BLUE, circle.getColor())
        );
    }

    @Test
    public void testChangeColorCircle1() throws ColorException {
        Circle circle = new Circle(10, 20, 10, Color.BLUE);
        circle.setColor(Color.GREEN);
        assertEquals(Color.GREEN, circle.getColor());
    }

    @Test
    public void testChangeColorCircle2() throws ColorException {
        Circle circle = new Circle(10, 20, 10, Color.BLUE);
        circle.setColor("GREEN");
        assertEquals(Color.GREEN, circle.getColor());
    }

    @Test
    public void testEnlargeCircle() throws ColorException {
        Circle circle = new Circle(10, 20, 10, Color.BLUE);
        circle.enlarge(5);
        assertAll(
                () -> assertEquals(10, circle.getCenter().getX()),
                () -> assertEquals(20, circle.getCenter().getY()),
                () -> assertEquals(50, circle.getRadius()),
                () -> assertEquals(Color.BLUE, circle.getColor())
        );
    }

    @Test
    public void testAreaCircle() throws ColorException {
        Circle circle = new Circle(10, 20, 10, Color.BLUE);
        assertEquals(Math.PI * 100, circle.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testPerimeterCircle() throws ColorException {
        Circle circle = new Circle(10, 20, 10, Color.BLUE);
        assertEquals(2 * Math.PI * 10, circle.getPerimeter(), DOUBLE_EPS);
    }

    @Test
    public void testIsPointInsideCircle1() throws ColorException {
        Circle circle = new Circle(10, 10, 10, Color.BLUE);
        assertAll(
                () -> assertTrue(circle.isInside(10, 10)),
                () -> assertTrue(circle.isInside(20, 10)),
                () -> assertTrue(circle.isInside(10, 20)),
                () -> assertTrue(circle.isInside(15, 15)),
                () -> assertFalse(circle.isInside(18, 18))
        );
    }

    @Test
    public void testIsPointInsideCircle2() throws ColorException {
        Circle circle = new Circle(new Point2D(10, 10), 10, Color.BLUE);
        assertAll(
                () -> assertTrue(circle.isInside(new Point2D(10, 10))),
                () -> assertTrue(circle.isInside(new Point2D(20, 10))),
                () -> assertTrue(circle.isInside(new Point2D(10, 20))),
                () -> assertTrue(circle.isInside(new Point2D(15, 15))),
                () -> assertFalse(circle.isInside(new Point2D(18, 18)))
        );
    }

    @Test
    public void testEqualsCircle() throws ColorException {
        Circle circle1 = new Circle(new Point2D(10, 10), 10, Color.BLUE);
        Circle circle2 = new Circle(new Point2D(10, 10), 10, Color.BLUE);
        Circle circle3 = new Circle(new Point2D(10, 10), 20, Color.BLUE);
        Circle circle4 = new Circle(new Point2D(0, 0), 20, Color.BLUE);
        Circle circle5 = new Circle(new Point2D(10, 10), 10, Color.GREEN);
        assertEquals(circle1, circle2);
        assertNotEquals(circle1, circle3);
        assertNotEquals(circle1, circle4);
        assertNotEquals(circle1, circle5);
    }

    @Test
    @SuppressWarnings("unused")
    public void testCircleFactory1() throws ColorException {
        CircleFactory.reset();
        Circle circle1 = CircleFactory.createCircle(new Point2D(0, 0), 1, Color.BLUE);
        Circle circle2 = CircleFactory.createCircle(new Point2D(3, 4), 1, Color.BLUE);
        Circle circle3 = CircleFactory.createCircle(new Point2D(10, 20), 1, Color.BLUE);
        assertEquals(3, CircleFactory.getCircleCount());
    }

    @Test
    @SuppressWarnings("unused")
    public void testCircleFactory2() throws ColorException {
        CircleFactory.reset();
        Circle circle1 = CircleFactory.createCircle(new Point2D(0, 0), 1, "BLUE");
        Circle circle2 = CircleFactory.createCircle(new Point2D(3, 4), 1, "BLUE");
        Circle circle3 = CircleFactory.createCircle(new Point2D(10, 20), 1, "BLUE");
        assertEquals(3, CircleFactory.getCircleCount());
    }
}
