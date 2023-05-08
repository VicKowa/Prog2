package Woche5;

import java.security.InvalidParameterException;

public class Ringpuffer<T> {

    private int front;
    private int back;
    private final int capacity;
    private int size;
    private T[] puffer;


    @SuppressWarnings("unchecked")
    public Ringpuffer(int capacity) {
        puffer = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
        front = -1;
        back = -1;
    }
    public int size() {
        return size;
    }

    public T get(int pos) throws 
		if(pos < 0 | pos >= size) {
            throw new InvalidParameterException();
        } else {
            return puffer[pos];
        }
    }

    public T set(int pos, T e) throws InvalidParameterException {
        if(puffer[pos] == null) {
            throw new InvalidParameterException();
        } else {
            T temp = puffer[pos];
            puffer[pos] = e;
            return temp;
        }


    }

    public void addFirst(T e) throws NoCapacityInArray {
        if(size == 0) {
            front = 0;
            back = 0;
            puffer[0] = e;
            size++;
            return;
        }

        if(size + 1 <= capacity) {
            if (front == 0) {
                puffer[capacity-1] = e;
                front = capacity-1;

            } else if(front <= capacity-1) {
                puffer[--front] = e;
            }
            size++;
        } else {
            throw new NoCapacityInArray();
        }
    }

    public void addLast(T e) throws NoCapacityInArray {
        if(size == 0) {
            front = 0;
            back = 0;
            puffer[0] = e;
            size++;
            return;
        }
        if(size + 1 <= capacity) {
            if(back < capacity-1) {
                puffer[back+1] = e;
                back++;
            } else if (back == capacity-1){
                puffer[0] = e;
                back = 0;
            }
            size++;
        } else {
            throw new NoCapacityInArray();
        }
    }

    public T removeFirst() throws IndexOutOfBoundsException {
        if(size <= 0) {
            throw new IndexOutOfBoundsException();
        } else {
            T temp = puffer[front];
            puffer[front] = null;
            if(front + 1 > capacity - 1) {
                front = 0;
            } else front++;
            size--;
            return temp;
        }
    }

    public T removeLast() throws IndexOutOfBoundsException {
        if(size <= 0) {
            throw new IndexOutOfBoundsException();
        } else {
            T temp = puffer[back];
            puffer[back] = null;
            if((back - 1) < 0) {
                back = capacity-1;
            } else back--;
            size--;
            return temp;
        }
    }
}
