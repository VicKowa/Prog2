package woche7;

import Woche5.NoCapacityInArray;
import Woche5.Ringpuffer;

public class FolgeMitRing<T> implements Folge<T> {

    private Ringpuffer<T> folge;
    public FolgeMitRing(int capacity) {
        folge = new Ringpuffer<>(capacity);
    }

    @Override
    public T remove() throws IndexOutOfBoundsException {
        return folge.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return folge.size() <= 0;
    }

    @Override
    public int size() {
        return folge.size();
    }

    @Override
    public int capacity() {
        return folge.capacity();
    }

    @Override
    public void insert(T e) throws NoCapacityInArray {
        folge.addLast(e);
    }
    @Override
    public void insert(int pos, T e) throws IndexOutOfBoundsException, NoCapacityInArray {
        folge.insert(pos, e);
    }

    @Override
    public T remove(int pos) throws IndexOutOfBoundsException {
        return folge.remove(pos);
    }

    @Override
    public T get(int pos) throws IndexOutOfBoundsException {
        return folge.get(pos);
    }

    @Override
    public T set(int pos, T e) throws NullPointerException{
        return folge.set(pos, e);
    }

    @Override
    public String toString() {
        if (size() == 0) {
            return "()";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for (int i = 0; i < size(); i++) {
                sb.append(folge.get(i));
                if (i != size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append(")");
            return sb.toString();
        }
    }
}
