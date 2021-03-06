package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;

import java.util.Objects;

public class Rectangle extends Figure {
    private Point2D leftTop;
    private Point2D rightBottom;

    public Rectangle(Point2D leftTop, Point2D rightBottom, Color color) throws ColorException {
        super(color);
        this.rightBottom = rightBottom;
        this.leftTop = leftTop;
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom, Color color) throws ColorException {
        this(new Point2D(xLeft, yTop), new Point2D(xRight, yBottom), color);
    }

    public Rectangle(int length, int width, Color color) throws ColorException {
        this(new Point2D(0, -width), new Point2D(length, 0), color);
    }

    public Rectangle(Color color) throws ColorException {
        this(new Point2D(0, -1), new Point2D(1, 0), color);
    }

    public Rectangle(Point2D leftTop, Point2D rightBottom, String color) throws ColorException {
        this(leftTop, rightBottom, Color.colorFromString(color));
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom, String color) throws ColorException {
        this(new Point2D(xLeft, yTop), new Point2D(xRight, yBottom), color);
    }

    public Rectangle(int length, int width, String color) throws ColorException {
        this(new Point2D(0, -width), new Point2D(length, 0), color);
    }

    public Rectangle(String color) throws ColorException {
        this(new Point2D(0, -1), new Point2D(1, 0), color);
    }

    public Point2D getTopLeft() {
        return leftTop;
    }

    public Point2D getBottomRight() {
        return rightBottom;
    }

    public void setTopLeft(Point2D leftTop) {
        this.leftTop = leftTop;
    }

    public void setBottomRight(Point2D rightBottom) {
        this.rightBottom = rightBottom;
    }

    public int getLength() {
        return Math.abs(this.rightBottom.getX() - this.leftTop.getX());
    }

    public int getWidth() {
        return Math.abs(this.leftTop.getY() - this.rightBottom.getY());
    }

    public void moveRel(int dx, int dy) {
        this.rightBottom.moveRel(dx, dy);
        this.leftTop.moveRel(dx, dy);
    }

    public void enlarge(int nx, int ny) {
        this.rightBottom.setX(this.leftTop.getX() + getLength() * nx);
        this.rightBottom.setY(this.leftTop.getY() + getWidth() * ny);
    }

    public double getArea() {
        return getLength() * getWidth();
    }

    public double getPerimeter() {
        return 2 * (getWidth() + getLength());
    }

    public boolean isInside(int x, int y) {
        return (x >= leftTop.getX() && x <= rightBottom.getX() && y >= leftTop.getY() && y <= rightBottom.getY());
    }

    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isInside(Rectangle rectangle) {
        return isInside(rectangle.rightBottom) && isInside(rectangle.leftTop);
    }

    public boolean isIntersects(Rectangle rectButton) {
        return !(this.leftTop.getX() > rectButton.rightBottom.getX() || this.rightBottom.getX() < rectButton.leftTop.getX() || this.leftTop.getY() > rectButton.rightBottom.getY() || this.rightBottom.getY() < rectButton.leftTop.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return leftTop.equals(rectangle.leftTop) &&
                rightBottom.equals(rectangle.rightBottom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), leftTop, rightBottom);
    }
}
