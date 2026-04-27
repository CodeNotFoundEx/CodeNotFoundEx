package com.codenotfoundex.micro.service.book1;

public class P_4_x_Eliminari {

    static int[][] memo;

    static void main() {
        String iaka = "abcxxcbta";
        int reduced = reduceString(iaka);
        System.out.println(reduced);

//        printMemo(memo);
    }

    private static void printMemo(int[][] memo) {
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int reduceString(String iaka) {
        int n = iaka.length();

        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            memo[i][i] = 1;
        }
        return reduceString(iaka, 0, n-1 );
    }

    private static int reduceString(String iaka, int i, int j) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (memo[i][j] != -1) return memo[i][j];
        int res = j-i+1; //worst case

        //divide
        for (int k = i; k < j; k++) {
            res = Math.min(res, reduceString(iaka, i, k) + reduceString(iaka, k + 1, j) );
        }
        //case for equal
        for (int k = i+1; k <= j; k++) {
            if(iaka.charAt(i) == iaka.charAt(k)) {
                int inside = reduceString(iaka, i + 1, k - 1);
                if (inside == 0) {
                    res = Math.min(res, reduceString(iaka, k + 1, j));
                }
            }
        }
        memo[i][j] = res;
        return res;

    }
}
