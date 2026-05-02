package c.prog.ch4;

public class P_Produsul_Cartesian_R {
    static void main() {

        int[] L = { 2, 3, 2};
        int n = L.length;
        int[] E = new int[n];
        generate(L, E, 0);

    }


    private static void generate(int[] L, int[] E, int index) {
        if( index == L.length) {
            printE(E);
            return;
        }
        for (int i = 0; i <= L[index]; i++) {
            E[index] = i;
            generate(L, E, index+1);
        }

    }

    static void printE(int[] E) {
        for (int i = 0; i < E.length; i++) {
            System.out.print(E[i] + " ");
        }
        System.out.println();
    }
}
