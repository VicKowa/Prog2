package woche11.aufgabe4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FolgeMitDynArray<T> implements Folge<T> {

    DynArray<T> folge;

    public FolgeMitDynArray() {
        folge = new DynArray<>();
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
    public void insert(T e) {
        folge.addLast(e);
    }

    @Override
    public T remove() throws NoSuchElementException {
        return folge.removeFirst();
    }

    @Override
    public Iterator<T> iterator() {
        return folge.iterator();
    }

    @Override
    public T get(int pos) throws IndexOutOfBoundsException {
        return folge.get(pos);
    }

    @Override
    public T set(int pos, T e) throws IndexOutOfBoundsException {
        return folge.set(pos, e);
    }

    @Override
    public T remove(int pos) throws IndexOutOfBoundsException {
        return folge.remove(pos);
    }

    @Override
    public void insert(int pos, T e) {
        folge.insert(pos, e);
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