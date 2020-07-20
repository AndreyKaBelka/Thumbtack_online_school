package net.thumbtack.school.boxes;

import net.thumbtack.school.figures.v3.Figure;

public class ArrayBox<T extends Figure> {
    private T[] content;

    ArrayBox(T[] content) {
        this.content = content;
    }

    public T[] getContent() {
        return content;
    }

    public void setContent(T[] content) {
        this.content = content;
    }

    public T getElement(int index) {
        return content[index];
    }

    public void setElement(int index, T element) {
        content[index] = element;
    }

    public boolean isSameSize(ArrayBox anotherArrayBox){
        return getContent().length == anotherArrayBox.getContent().length;
    }


}
