package Woche5;

public class NoCapacityInArray extends RuntimeException {

    public NoCapacityInArray() {
        super("Every Index is in use");
    }
    public NoCapacityInArray(String msg) {
        super(msg);
    }
}
