package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorErrorCode;
import net.thumbtack.school.colors.ColorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCylinder {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testCylinder1A() throws ColorException {
        Point2D center = new Point2D(10, 20);
        Cylinder cylinder = new Cylinder(center, 10, 10, Color.BLUE);
        assertAll(
                () -> assertEquals(10, cylinder.getCenter().getX()),
                () -> assertEquals(20, cylinder.getCenter().getY()),
                () -> assertEquals(10, cylinder.getRadius()),
                () -> assertEquals(10, cylinder.getHeight()),
                () -> assertEquals(Color.BLUE, cylinder.getColor())
        );
    }

    @Test
    public void testCylinder1B() throws ColorException {
        Point2D center = new Point2D(10, 20);
        Cylinder cylinder = new Cylinder(center, 10, 10, "BLUE");
        assertAll(
                () -> assertEquals(10, cylinder.getCenter().getX()),
                () -> assertEquals(20, cylinder.getCenter().getY()),
                () -> assertEquals(10, cylinder.getRadius()),
                () -> assertEquals(10, cylinder.getHeight()),
                () -> assertEquals(Color.BLUE, cylinder.getColor())
        );
    }

    @Test
    public void testCylinder2A() throws ColorException {
        Cylinder cylinder = new Cylinder(10, 20, 10, 10, Color.BLUE);
        assertAll(
                () -> assertEquals(10, cylinder.getCenter().getX()),
                () -> assertEquals(20, cylinder.getCenter().getY()),
                () -> assertEquals(10, cylinder.getRadius()),
                () -> assertEquals(10, cylinder.getHeight()),
                () -> assertEquals(Color.BLUE, cylinder.getColor())
        );
    }

    @Test
    public void testCylinder2B() throws ColorException {
        Cylinder cylinder = new Cylinder(10, 20, 10, 10, "BLUE");
        assertAll(
                () -> assertEquals(10, cylinder.getCenter().getX()),
                () -> assertEquals(20, cylinder.getCenter().getY()),
                () -> assertEquals(10, cylinder.getRadius()),
                () -> assertEquals(10, cylinder.getHeight()),
                () -> assertEquals(Color.BLUE, cylinder.getColor())
        );
    }

    @Test
    public void testCylinder3A() throws ColorException {
        Cylinder cylinder = new Cylinder(10, 10, Color.BLUE);
        assertAll(
                () -> assertEquals(0, cylinder.getCenter().getX()),
                () -> assertEquals(0, cylinder.getCenter().getY()),
                () -> assertEquals(10, cylinder.getRadius()),
                () -> assertEquals(10, cylinder.getHeight()),
                () -> assertEquals(Color.BLUE, cylinder.getColor())
        );
    }

    @Test
    public void testCylinder3B() throws ColorException {
        Cylinder cylinder = new Cylinder(10, 10, "BLUE");
        assertAll(
                () -> assertEquals(0, cylinder.getCenter().getX()),
                () -> assertEquals(0, cylinder.getCenter().getY()),
                () -> assertEquals(10, cylinder.getRadius()),
                () -> assertEquals(10, cylinder.getHeight()),
                () -> assertEquals(Color.BLUE, cylinder.getColor())
        );
    }

    @Test
    public void testCylinder4A() throws ColorException {
        Cylinder cylinder = new Cylinder(Color.BLUE);
        assertAll(
                () -> assertEquals(0, cylinder.getCenter().getX()),
                () -> assertEquals(0, cylinder.getCenter().getY()),
                () -> assertEquals(1, cylinder.getRadius()),
                () -> assertEquals(1, cylinder.getHeight()),
                () -> assertEquals(Color.BLUE, cylinder.getColor())
        );
    }

    @Test
    public void testCylinder4B() throws ColorException {
        Cylinder cylinder = new Cylinder("BLUE");
        assertAll(
                () -> assertEquals(0, cylinder.getCenter().getX()),
                () -> assertEquals(0, cylinder.getCenter().getY()),
                () -> assertEquals(1, cylinder.getRadius()),
                () -> assertEquals(1, cylinder.getHeight()),
                () -> assertEquals(Color.BLUE, cylinder.getColor())
        );
    }


    @Test
    public void testMoveRelCylinder() throws ColorException {
        Cylinder cylinder = new Cylinder(10, 20, 10, 10, Color.BLUE);
        cylinder.moveRel(100, 50);
        assertAll(
                () -> assertEquals(110, cylinder.getCenter().getX()),
                () -> assertEquals(70, cylinder.getCenter().getY()),
                () -> assertEquals(10, cylinder.getRadius()),
                () -> assertEquals(10, cylinder.getHeight())
        );
    }

    @Test
    public void testChangeColorCylinder1() throws ColorException {
        Cylinder cylinder = new Cylinder(10, 20, 10, 10, Color.BLUE);
        cylinder.setColor(Color.GREEN);
        assertEquals(Color.GREEN, cylinder.getColor());
    }

    @Test
    public void testChangeColorCylinder2() throws ColorException {
        Cylinder cylinder = new Cylinder(10, 20, 10, 10, "BLUE");
        cylinder.setColor(Color.GREEN);
        assertEquals(Color.GREEN, cylinder.getColor());
    }

    @Test
    @SuppressWarnings("unused")
    public void testCylinderWrongColor() {
        try {
            Cylinder cylinder = new Cylinder(10, 20, 10, 10, "YELLOW");
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.WRONG_COLOR_STRING, ex.getErrorCode());
        }
        try {
            Cylinder cylinder = new Cylinder(10, 20, 10, 10, (String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Cylinder cylinder = new Cylinder(10, 20, 10, 10, (Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Cylinder cylinder = new Cylinder(10, 20, 10, 10, "BLUE");
            cylinder.setColor((Color) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
        try {
            Cylinder cylinder = new Cylinder(10, 20, 10, 10, "BLUE");
            cylinder.setColor((String) null);
            fail();
        } catch (ColorException ex) {
            assertEquals(ColorErrorCode.NULL_COLOR, ex.getErrorCode());
        }
    }

    @Test
    public void testEnlargeCylinder() throws ColorException {
        Cylinder cylinder = new Cylinder(10, 20, 10, 10, Color.BLUE);
        cylinder.enlarge(5);
        assertAll(
                () -> assertEquals(10, cylinder.getCenter().getX()),
                () -> assertEquals(20, cylinder.getCenter().getY()),
                () -> assertEquals(50, cylinder.getRadius()),
                () -> assertEquals(10, cylinder.getHeight())
        );
    }

    @Test
    public void testAreaCylinder() throws ColorException {
        Cylinder cylinder = new Cylinder(10, 20, 10, 10, Color.BLUE);
        assertEquals(Math.PI * 100, cylinder.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testVolumeCylinder() throws ColorException {
        Cylinder cylinder = new Cylinder(10, 20, 10, 10, Color.BLUE);
        assertEquals(Math.PI * 1000, cylinder.getVolume(), DOUBLE_EPS);
    }

    @Test
    public void testPerimeterCylinder() throws ColorException {
        Cylinder cylinder = new Cylinder(10, 20, 10, 10, Color.BLUE);
        assertEquals(2 * Math.PI * 10, cylinder.getPerimeter(), DOUBLE_EPS);
    }

    @Test
    public void testIsPointInsideCylinder1() throws ColorException {
        Cylinder cylinder = new Cylinder(10, 10, 10, 10, Color.BLUE);
        assertAll(
                () -> assertTrue(cylinder.isInside(10, 10, 10)),
                () -> assertTrue(cylinder.isInside(20, 10, 10)),
                () -> assertTrue(cylinder.isInside(10, 20, 10)),
                () -> assertTrue(cylinder.isInside(15, 15, 10))
        );
    }

    @Test
    public void testIsPointInsideCylinder2() throws ColorException {
        Cylinder cylinder = new Cylinder(new Point2D(10, 10), 10, 10, Color.BLUE);
        assertAll(
                () -> assertTrue(cylinder.isInside(new Point3D(10, 10, 10))),
                () -> assertTrue(cylinder.isInside(new Point3D(20, 10, 10))),
                () -> assertTrue(cylinder.isInside(new Point3D(10, 20, 10))),
                () -> assertTrue(cylinder.isInside(new Point3D(15, 15, 10)))
        )
        ;
    }

    @Test
    public void testEqualsCylinder() throws ColorException {
        Cylinder cylinder1 = new Cylinder(new Point2D(10, 10), 10, 10, Color.BLUE);
        Cylinder cylinder2 = new Cylinder(new Point2D(10, 10), 10, 10, Color.BLUE);
        Cylinder cylinder3 = new Cylinder(new Point2D(10, 10), 20, 10, Color.BLUE);
        Cylinder cylinder4 = new Cylinder(new Point2D(0, 0), 10, 10, Color.BLUE);
        assertEquals(cylinder1, cylinder2);
        assertNotEquals(cylinder1, cylinder3);
        assertNotEquals(cylinder1, cylinder4);
    }

}
