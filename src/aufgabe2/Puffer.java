package aufgabe2;

public interface Puffer {

    public boolean isEmpty();
    public int size();
    public int capacity();
    public void insert(int e);
    public int remove();
}
