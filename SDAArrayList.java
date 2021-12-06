package JavaAdvancedCollectionsEx1;

import java.util.Arrays;

public class SDAArrayList<E> {
    private static final int InitialCapacity = 5;
    private Object[] elementArray;
    private int size = 0;

    public SDAArrayList() {
        elementArray = new Object[InitialCapacity];
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bound exception. Please provide valid index!");
        }
        return (E) elementArray[index];
    }

    public void add(E e) {
        if (size == elementArray.length) {
            increaseArraySize();
        }
        elementArray[size++] = e;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bound2 . Please provide a valid index!!");
        }
        Object removedElement = elementArray[index];
        for (int i = index; i < size; i++) {
            elementArray[i] = elementArray[i + 1];
        }
        size--;
        decreaseArraySize();
        return (E) removedElement;
    }

    public void dispaly() {
        for (Object element : elementArray) {
            System.out.println(element);
        }
    }

    public void decreaseArraySize() {
        elementArray = Arrays.copyOf(elementArray, elementArray.length - 1);
    }

    public void increaseArraySize() {
        int newIncreasedCapacity = elementArray.length * 2;
        elementArray = Arrays.copyOf(elementArray, newIncreasedCapacity);
    }
}
