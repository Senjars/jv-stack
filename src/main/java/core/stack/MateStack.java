package core.stack;

import java.util.EmptyStackException;

public class MateStack<T> {
    private int size = 0;
    private int arrayCapacity = 16;
    private T[] array = (T[]) new Object[arrayCapacity];

    public void push(T value) {
        if (size >= arrayCapacity) {
            arrayCapacity *= 2;
            T[] newArray = (T[]) new Object[arrayCapacity];

            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        size++;
        array[size - 1] = value;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return array[size - 1];
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        size--;
        T result = array[size];
        array[size] = null;
        return result;
    }

    public int size() {
        return size;
    }
}
