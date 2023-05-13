package Woche5;

public class Ringpuffer<T> {

    private int front;
    private final int capacity;
    private int size;
    private T[] puffer;


    @SuppressWarnings("unchecked")
    public Ringpuffer(int capacity) {
        puffer = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
        front = 0;
    }

    public int capacity() {
        return puffer.length;
    }

    public int size() {
        return size;
    }

    public T get(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 | (pos > size)) {
            throw new IndexOutOfBoundsException();
        } else {
            return puffer[calcback(pos-1)];
        }
    }

    public T set(int pos, T e) throws NullPointerException {
        if (pos < 0 | (pos > size)) {
            throw new NullPointerException();
        } else {
            T temp = puffer[calcback(pos-1)];
            puffer[calcback(pos -1)] = e;
            return temp;
        }


    }

    public void addFirst(T e) throws NoCapacityInArray {
        if (size == capacity) {
            throw new NoCapacityInArray();
        }
        front = (front - 1 + capacity) % capacity;
        puffer[front] = e;
        size++;

    }

    public void addLast(T e) throws NoCapacityInArray {
        if (size == capacity) {
            throw new NoCapacityInArray();
        }
        puffer[calcback(size)] = e;
        size++;
    }

    public T removeFirst() throws IndexOutOfBoundsException {
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        }
        T temp = puffer[front];
        puffer[front] = null;
        front = (front + 1) % capacity;
        size--;
        return temp;
    }

    public T removeLast() throws IndexOutOfBoundsException {
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        }
        size--;
        T temp = puffer[calcback(size)];
        puffer[calcback(size)] = null;
        return temp;

    }

    public T remove(int pos) throws IndexOutOfBoundsException {
        if(pos < 0 | pos > size) {
            throw new IndexOutOfBoundsException();
        }
        T temp = get(pos);
        for (int i = pos; i < size; i++) {
            set(i, get(i+1));
        }
        size--;
        return temp;

    }

    public void insert(int pos, T e) throws IndexOutOfBoundsException, NoCapacityInArray {
        if(pos < 0 | pos > size) {
            throw new IndexOutOfBoundsException();
        }
        if(capacity == size) {
            throw new NoCapacityInArray();
        }
        //hinterstes El doppelt anfügen
        addLast(get(size));// in addLast wird size++ aufgerufen

        for (int i = size-2; i >= pos; i--) {
            set(i, get(i+1));
        }
        set(pos, e);

    }

    private int calcback(int pos) {
        return (front + pos) % capacity;
    }

    @Override
    public String toString() {
        String output = "(";
        output += get(1);
        for (int i = 2; i <= size; i++) {
            output += ", ";
           output += get(i);

        }
        return output +")";
    }
}
