package net.thumbtack.school.figures.v2;

import java.util.Arrays;

public class Triangle extends Figure {
    private Point2D[] point2DS = new Point2D[3];

    public Triangle(Point2D point1, Point2D point2, Point2D point3, int color) {
        super(color);
        point2DS[0] = point1;
        point2DS[1] = point2;
        point2DS[2] = point3;
    }

    public Point2D getPoint1() {
        return point2DS[0];
    }

    public Point2D getPoint2() {
        return point2DS[1];
    }

    public Point2D getPoint3() {
        return point2DS[2];
    }

    public void setPoint1(Point2D point) {
        point2DS[0] = point;
    }

    public void setPoint2(Point2D point) {
        point2DS[1] = point;
    }

    public void setPoint3(Point2D point) {
        point2DS[2] = point;
    }

    public double getSide12() {
        return getSlide(0, 1);
    }

    public double getSide13() {
        return getSlide(0, 2);
    }

    public double getSide23() {
        return getSlide(1, 2);
    }

    public double getSlide(int a, int b) {
        return Math.sqrt(Math.pow(point2DS[b].getX() - point2DS[a].getX(), 2) + Math.pow(point2DS[b].getY() - point2DS[a].getY(), 2));
    }

    public void moveRel(int dx, int dy) {
        for (Point2D point2D : point2DS) {
            point2D.moveRel(dx, dy);
        }
    }

    public double getArea() {
        double halfPer = getPerimeter() / 2;
        return Math.sqrt(halfPer * (halfPer - getSide12()) * (halfPer - getSide13()) * (halfPer - getSide23()));
    }

    public double getPerimeter() {
        return getSide12() + getSide13() + getSide23();
    }

    public boolean isInside(int x, int y) {
        int a = (point2DS[0].getX() - x) * (point2DS[1].getY() - point2DS[0].getY()) - (point2DS[1].getX() - point2DS[0].getX()) * (point2DS[0].getY() - y);
        int b = (point2DS[1].getX() - x) * (point2DS[2].getY() - point2DS[1].getY()) - (point2DS[2].getX() - point2DS[1].getX()) * (point2DS[1].getY() - y);
        int c = (point2DS[2].getX() - x) * (point2DS[0].getY() - point2DS[2].getY()) - (point2DS[0].getX() - point2DS[2].getX()) * (point2DS[2].getY() - y);
        return (a >= 0 && b >= 0 && c >= 0) || (a <= 0 && b <= 0 && c <= 0);
    }


    public boolean isInside(Point2D point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return Arrays.equals(point2DS, triangle.point2DS);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(point2DS);
        return result;
    }
}
