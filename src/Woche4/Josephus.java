package Woche4;

public class Josephus {

    public static int loese(int n, int k) {
        RDVL<Integer> rdvl = new RDVL<>();
        rdvl.add(1);
        for (int i = n; i > 1; i--) {
            rdvl.add(i);
        }

        while (rdvl.size() > 1) {
            rdvl.next(k-1);
            rdvl.remove();
        }
        return rdvl.element();
    }

    public static void main(String[] args) {
        System.out.println(loese(1,1));
    }
}
