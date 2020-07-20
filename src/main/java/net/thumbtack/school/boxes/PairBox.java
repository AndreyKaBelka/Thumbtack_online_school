package net.thumbtack.school.boxes;

import net.thumbtack.school.area.HasArea;
import net.thumbtack.school.figures.v3.Figure;

public class PairBox<T extends Figure, E extends Figure> implements HasArea {
    private T contentFirst;
    private E contentSecond;

    public PairBox(T contentFirst, E contentSecond) {
        this.contentFirst = contentFirst;
        this.contentSecond = contentSecond;
    }

    public T getContentFirst() {
        return contentFirst;
    }

    public E getContentSecond() {
        return contentSecond;
    }

    public void setContentFirst(T contentFirst) {
        this.contentFirst = contentFirst;
    }

    public void setContentSecond(E contentSecond) {
        this.contentSecond = contentSecond;
    }


    @Override
    public double getArea() {
        return contentFirst.getArea() + contentSecond.getArea();
    }

    public boolean isAreaEqual(PairBox pairBox) {
        return getArea() == pairBox.getArea();
    }

    public static boolean isAreaEqual(PairBox pairBox1, PairBox pairBox2) {
        return pairBox1.getArea() == pairBox2.getArea();
    }
}
