package Woche2.zusatzaufgabe;

public class ProjektEuler {


    public static int ggt(int a, int b) {

        if (a == 0) {
            return b;
        }
        while (b != 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }
    public static int euler(int range) {
        int summe = 0;

        for (int i = 1; i < range; i++) {
            if(ggt(i,3) == 3 | ggt(i, 5) == 5) {
                summe += i;
            }
        }
        return summe;
    }
}
