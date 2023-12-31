public class Stack<T> {
    private T[] data;
    private int size;
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public void push(T element) {
        if (size == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[size] = element;
        size++;
    }
    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        size--;
        return data[size];
    }
    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return data[size-1];
    }
}

