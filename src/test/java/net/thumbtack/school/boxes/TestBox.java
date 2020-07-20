package net.thumbtack.school.boxes;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;
import net.thumbtack.school.figures.v3.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBox {
    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testRectangleBox() throws ColorException {
        Point2D topLeft = new Point2D(10, 20);
        Point2D bottomRight = new Point2D(30, 40);
        Rectangle rect = new Rectangle(topLeft, bottomRight, Color.BLUE);
        Box<Rectangle> rectBox = new Box<>(rect);
        assertEquals(10, rectBox.getContent().getTopLeft().getX());
        assertEquals(20, rectBox.getContent().getTopLeft().getY());
        assertEquals(30, rectBox.getContent().getBottomRight().getX());
        assertEquals(40, rectBox.getContent().getBottomRight().getY());
        assertEquals(rectBox.getContent().getLength(), 20);
        assertEquals(rectBox.getContent().getWidth(), 20);
        assertEquals(Color.BLUE, rectBox.getContent().getColor());
        assertEquals(400, rectBox.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testCylinderBox() throws ColorException {
        Point2D center = new Point2D(10, 20);
        Cylinder cylinder = new Cylinder(center, 10, 10, Color.BLUE);
        Box<Cylinder> cylinderBox = new Box<>(cylinder);
        assertEquals(10, cylinderBox.getContent().getCenter().getX());
        assertEquals(20, cylinderBox.getContent().getCenter().getY());
        assertEquals(10, cylinderBox.getContent().getRadius());
        assertEquals(10, cylinderBox.getContent().getHeight());
        assertEquals(Color.BLUE, cylinderBox.getContent().getColor());
        assertEquals(100 * Math.PI, cylinderBox.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testAreaBox() throws ColorException {
        Point2D topLeft = new Point2D(10, 20);
        Point2D bottomRight = new Point2D(30, 40);
        Rectangle rect = new Rectangle(topLeft, bottomRight, Color.BLUE);
        Box<Rectangle> rectBox = new Box<>(rect);
        assertEquals(400, rectBox.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testAreaEqualBox1() throws ColorException {
        Point2D topLeft = new Point2D(10, 20);
        Point2D bottomRight = new Point2D(30, 60);
        Rectangle rect = new Rectangle(topLeft, bottomRight, Color.BLUE);
        Box<Rectangle> rectBox = new Box<>(rect);
        Point2D pt1 = new Point2D(0, 0);
        Point2D pt2 = new Point2D(40, 0);
        Point2D pt3 = new Point2D(0, 40);
        Triangle triangle = new Triangle(pt1, pt2, pt3, Color.BLUE);
        Box<Triangle> triangleBox = new Box<>(triangle);
        assertTrue(triangleBox.isAreaEqual(rectBox));
    }

    @Test
    public void testAreaEqualBox2() throws ColorException {
        Point2D topLeft = new Point2D(10, 20);
        Point2D bottomRight = new Point2D(30, 60);
        Rectangle rect = new Rectangle(topLeft, bottomRight, Color.BLUE);
        Box<Rectangle> rectBox = new Box<>(rect);
        Point2D pt1 = new Point2D(0, 0);
        Point2D pt2 = new Point2D(40, 0);
        Point2D pt3 = new Point2D(0, 40);
        Triangle triangle = new Triangle(pt1, pt2, pt3, Color.BLUE);
        Box<Triangle> triangleBox = new Box<>(triangle);
        assertTrue(Box.isAreaEqual(rectBox, triangleBox));
    }

    @Test
    public void testRectangleArrayBox() throws ColorException {
        Point2D topLeft1 = new Point2D(10, 20);
        Point2D bottomRight1 = new Point2D(30, 60);
        Rectangle rect1 = new Rectangle(topLeft1, bottomRight1, Color.BLUE);
        Point2D topLeft2 = new Point2D(20, 10);
        Point2D bottomRight2 = new Point2D(60, 30);
        Rectangle rect2 = new Rectangle(topLeft2, bottomRight2, Color.BLUE);
        Rectangle[] rects1 = new Rectangle[]{rect1, rect2};
        ArrayBox<Rectangle> rectArrayBox1 = new ArrayBox<>(rects1);
        Rectangle[] rects2 = new Rectangle[]{rect2, rect1};
        ArrayBox<Rectangle> rectArrayBox2 = new ArrayBox<>(rects2);
        assertTrue(rectArrayBox1.isSameSize(rectArrayBox2));
    }

    @Test
    public void testRectangleTriangleArrayBoxes() throws ColorException {
        Point2D topLeft1 = new Point2D(10, 20);
        Point2D bottomRight1 = new Point2D(30, 60);
        Rectangle rect1 = new Rectangle(topLeft1, bottomRight1, Color.BLUE);
        Point2D topLeft2 = new Point2D(20, 10);
        Point2D bottomRight2 = new Point2D(60, 30);
        Rectangle rect2 = new Rectangle(topLeft2, bottomRight2, Color.BLUE);
        Rectangle[] rects = new Rectangle[]{rect1, rect2};
        ArrayBox<Rectangle> rectArrayBox = new ArrayBox<>(rects);
        Point2D pt1 = new Point2D(0, 0);
        Point2D pt2 = new Point2D(40, 0);
        Point2D pt3 = new Point2D(0, 40);
        Triangle triangle = new Triangle(pt1, pt2, pt3, Color.BLUE);
        Triangle[] triangles = new Triangle[]{triangle};
        ArrayBox<Triangle> triangleArrayBox = new ArrayBox<>(triangles);
        assertFalse(rectArrayBox.isSameSize(triangleArrayBox));
    }

    @Test
    public void testPairBox1() throws ColorException {
        Point2D topLeft = new Point2D(10, 20);
        Point2D bottomRight = new Point2D(30, 60);
        Rectangle rect = new Rectangle(topLeft, bottomRight, Color.BLUE);
        Point2D center = new Point2D(10, 20);
        Circle circle = new Circle(center, 10, Color.BLUE);
        PairBox<Rectangle, Circle> pairBox1 = new PairBox<>(rect, circle);
        PairBox<Circle, Rectangle> pairBox2 = new PairBox<>(circle, rect);
        assertTrue(pairBox1.isAreaEqual(pairBox2));
        assertTrue(PairBox.isAreaEqual(pairBox1, pairBox2));
    }

    @Test
    public void testPairBox2() throws ColorException {
        Point2D topLeft = new Point2D(10, 20);
        Point2D bottomRight = new Point2D(30, 60);
        Rectangle rect = new Rectangle(topLeft, bottomRight, Color.BLUE);
        Rectangle3D rect3D = new Rectangle3D(topLeft, bottomRight, 10, Color.BLUE);
        PairBox<Rectangle, Rectangle3D> pairBox1 = new PairBox<>(rect, rect3D);
        PairBox<Rectangle3D, Rectangle> pairBox2 = new PairBox<>(rect3D, rect);
        assertTrue(pairBox1.isAreaEqual(pairBox2));
        assertTrue(PairBox.isAreaEqual(pairBox1, pairBox2));
    }

    @Test
    public void testRectangleNamedBox() throws ColorException {
        Point2D topLeft = new Point2D(10, 20);
        Point2D bottomRight = new Point2D(30, 40);
        Rectangle rect = new Rectangle(topLeft, bottomRight, Color.BLUE);
        NamedBox<Rectangle> rectBox = new NamedBox<>(rect, "Very good rect");
        assertEquals(10, rectBox.getContent().getTopLeft().getX());
        assertEquals(20, rectBox.getContent().getTopLeft().getY());
        assertEquals(30, rectBox.getContent().getBottomRight().getX());
        assertEquals(40, rectBox.getContent().getBottomRight().getY());
        assertEquals(rectBox.getContent().getLength(), 20);
        assertEquals(rectBox.getContent().getWidth(), 20);
        assertEquals(Color.BLUE, rectBox.getContent().getColor());
        assertEquals(400, rectBox.getArea(), DOUBLE_EPS);
        assertEquals("Very good rect", rectBox.getName());
    }

    @Test
    public void testAreaNamedBox() throws ColorException {
        Point2D topLeft = new Point2D(10, 20);
        Point2D bottomRight = new Point2D(30, 40);
        Rectangle rect = new Rectangle(topLeft, bottomRight, Color.BLUE);
        NamedBox<Rectangle> rectBox = new NamedBox<>(rect, "Very good rect");
        assertEquals(400, rectBox.getArea(), DOUBLE_EPS);
        assertEquals("Very good rect", rectBox.getName());
    }

/*	@Test
	public void testMustNotBeCompiled() {
		Box<String> stringBox = new Box<>("My String");
	}*/
}
