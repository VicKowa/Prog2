package Woche5.Tests;

import Woche5.Temperatursensor;

public class TestTemperatur {
    public static void main(String[] args) {
        Temperatursensor t = new Temperatursensor();
        float temp = 15.0f;
        for (int i = 0; i <= 25; i++) {
            t.neueMessung(temp);
            temp += 0.75f;
        }
        System.out.println(t.aktuelleTemperatur());
        System.out.println(t.durchschittsTemperatur());
        t.neueMessung(34.0f);
        System.out.println(t.aktuelleTemperatur());
        t.reset();
        System.out.println(t.durchschittsTemperatur());
        System.out.println(t.aktuelleTemperatur());


    }
}
