package c.prog.ch4;


public class P_Diagonals {

    static void main() {
        int[][] a = {
                {1, 2, 3, 4, 5, 6, 7},
                {5, 6, 7, 8, 9, 10, 11},
                {9, 10, 11, 12, 13, 14, 15},
                {13, 14, 15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24, 25, 26},
                {21, 22, 23, 24, 25, 26, 27},
                {22, 23, 24, 25, 26, 27, 28}
        };
//        printPrincipalDiagonal(a);
//        printSecondaryDiagonal(a);

        int n = a.length;
        int[][] iaka = new int[n][n];
        //extract 1>
        for (int j = 0; j < (n+1)/2; j++) {
//            iaka = new int[n-j*2];
            for (int i = j; i < n-j; i++) {
                iaka[i][j] = a[i][j];
//                System.out.printf("%2d, ", a[i][j]);
            }

        }
        System.out.println("--- --- --- ---");
        printVertical(iaka);


    }

    public static void printVertical(int[][] iaka){
        for (int i = 0; i < iaka.length; i++) {
            for (int j = 0; j < iaka[i].length; j++) {
                if(iaka[i][j] != 0) {
                    System.out.printf("%2d ", iaka[i][j]);
                } else {
                    System.out.printf("%2s ", " ");
                }
            }
            System.out.println();
        }

    }

//    public static void printVertical(int n, int[] a, int j){
//
//        int size = a.length;
//        for (int i = 0; i < (n-size)/2; i++) {
//            System.out.printf("%2s\n", " ");
//        }
//        for (int i = 0; i < a.length; i++) {
//            System.out.printf("%2d\n", a[i]);
//        }
//        for (int i = 0; i < (n-size)/2; i++) {
//            System.out.printf("%2s\n", " ");
//        }
//    }

    private static void downLeft(int n, int[][] a) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(a[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void printPrincipalDiagonal(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i][i] + ", ");
        }
        System.out.println();
    }

    public static void printSecondaryDiagonal(int[][] a) {
        int n = a.length;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[n - i - 1][i] + ", ");
        }
        System.out.println();
    }

}



