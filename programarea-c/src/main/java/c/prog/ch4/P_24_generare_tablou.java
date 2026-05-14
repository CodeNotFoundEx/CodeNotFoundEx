package c.prog.ch4;

public class P_24_generare_tablou {
    static void main() {
        int n = 9;
        int[][] a = new int[n][n];

//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < n-j; i++) {
//                a[i+j][i] = 1+j;
//                a[i][i+j] = 1+j;
//            }
//        }

        //fill rows based on patterns v2
//        for (int i = 0; i < n; i++) {
//            a[i] = fillRow(i, n);
//        }

//        for (int i = 0; i < n; i++) {
//            a[i][i] = 1;
//        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n-j; i++) {
                a[i + j][i] = j;;
            }
        }

        printMatrix(n, a);
    }

    private static int[] fillRow(int i, int n) {
        int[] row = new int[n];
        int index = 0;
        for (int j = i; j > 0; j--) {
            row[index++] = j + 1;
        }
        for (int j = 0; j < (n - i); j++) {
            row[index++] = j + 1;
        }
        return row;
    }

    private static void printMatrix(int n, int[][] a) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%2d ", a[i][j]);
            }
            System.out.println();
        }
    }
}
