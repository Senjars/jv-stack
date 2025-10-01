package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private int size = 0;
    private T[] array;

    @SuppressWarnings("unchecked")
    public MateStack() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T value) {
        ensureCapacity(size + 1);
        array[size++] = value;
    }

    public T peek() {
        ensureNotEmpty();
        return array[size - 1];
    }

    public T pop() {
        ensureNotEmpty();
        T result = array[size - 1];
        array[size - 1] = null;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureNotEmpty() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = array.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            T[] newArray = (T[]) new Object[newCapacity];
            System.arraycopy(array,0,newArray,0,size);
            array = newArray;
        }
    }
}
