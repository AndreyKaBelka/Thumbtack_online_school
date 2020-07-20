package net.thumbtack.school.figures.v3;

import net.thumbtack.school.area.HasArea;
import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFigure {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testCompareArea() throws ColorException {
        Figure rect = new Rectangle(0, 0, 10, 10, Color.BLUE);
        Point2D point1 = new Point2D(0, 0);
        Point2D point2 = new Point2D(10, 10);
        Point2D point3 = new Point2D(0, 10);
        Figure triangle = new Triangle(point1, point2, point3, Color.BLUE);
        assertEquals(rect.getArea() / 2, triangle.getArea(), DOUBLE_EPS);
    }

    @Test
    public void testIsInside1() throws ColorException {
        Figure[] figures = new Figure[3];
        figures[0] = new Circle(0, 0, 10, Color.BLUE);
        figures[1] = new Rectangle(-10, -20, 10, 20, Color.BLUE);
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        figures[2] = new Triangle(point1, point2, point3, Color.BLUE);
        for (Figure figure : figures)
            assertTrue(figure.isInside(0, 0));
    }

    @Test
    public void testIsInside2() throws ColorException {
        Figure[] figures = new Figure[3];
        figures[0] = new Circle(0, 0, 10, Color.BLUE);
        figures[1] = new Rectangle(-10, -20, 10, 20, Color.BLUE);
        Point2D point1 = new Point2D(2, 0);
        Point2D point2 = new Point2D(-1, 0);
        Point2D point3 = new Point2D(0, 2);
        figures[2] = new Triangle(point1, point2, point3, Color.BLUE);
        for (Figure figure : figures)
            assertTrue(figure.isInside(new Point2D(0, 0)));
    }

    @Test
    public void testMoveRel() throws ColorException {
        Rectangle rect = new Rectangle(0, 0, 10, 10, Color.BLUE);
        Figure figure = rect;
        figure.moveRel(10, 10);
        assertAll(
                () -> assertEquals(10, rect.getTopLeft().getX()),
                () -> assertEquals(10, rect.getTopLeft().getY()),
                () -> assertEquals(20, rect.getBottomRight().getX()),
                () -> assertEquals(20, rect.getBottomRight().getY())
        );

    }

    @Test
    public void testHaveAreaImplemented() {
        assertTrue(HasArea.class.isInterface());
        assertTrue(HasArea.class.isAssignableFrom(Figure.class));
    }
}
