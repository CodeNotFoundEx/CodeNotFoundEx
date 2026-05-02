package c.prog.ch4;

public class P_Produsul_Cartesian {
    static void main() {
        int[] L = {3, 2, 3, 2};
        int n = L.length;

        int[] E = new int[n];
        int i, count=0;
        boolean done = false;

        while (!done) {
            printE(E);
            count++;
            for (i = n - 1; i >= 0 && L[i] == E[i]; i--) {
                E[i] = 0;
            }
            if (i < 0) done = true;
            else E[i]++;
        }
        System.out.println("Total: " + count);

    }

    private static void printE(int[] E) {
        for (int i = 0; i < E.length; i++) {
            System.out.print(E[i] + " ");
        }
        System.out.println();
    }
}
