package Woche5;

public class Temperatursensor {

    Ringpuffer<Float> memory = new Ringpuffer<>(25);

    public void neueMessung(Float wert) {
        try {
            memory.addLast(wert);
        } catch (NoCapacityInArray e) {
            memory.removeFirst();
            memory.addLast(wert);
        }

    }

    public Float aktuelleTemperatur() {
        try {
            float temp = memory.removeLast();
            memory.addLast(temp);
            return temp;
        } catch (IndexOutOfBoundsException e) {
            return Float.NaN;
        }
    }

    public Float durchschittsTemperatur() {
        if (memory.size() == 0) {
            return Float.NaN;
        } else {
            Float calc = 0f;
            for (int i = 0; i < memory.size()-1; i++) {
                calc += memory.get(i);
            }
            calc /= memory.size();
            return calc;
        }
    }

    public void reset() {
        while(memory.size() > 0) {
            memory.removeLast();
        }
    }
}
