package com.codenotfoundex.micro.service.book1;

import java.util.Arrays;

public class Px2_Conints_DP_2 {
    static int[] coins = {1, 5, 7};

    static int[] mem;
    static int[] choice;
    private static final int INF = Integer.MAX_VALUE - 100;;


    static void main() {
        int sum = 17;
        mem = new int[sum + 1];
        choice = new int[sum + 1];
        Arrays.fill(mem, -1);
        Arrays.fill(choice, -1);

        int sol = solve(sum);
        System.out.println(sol);
        printCoins(sum);

    }

    private static void printCoins(int sum) {
        if(choice[sum] == -1) {
            System.out.println("No solution");
            return;
        }
        System.out.println("Coins used:");
        int iaka = sum;
        while (iaka > 0) {
            System.out.println(choice[iaka]);
            iaka -= choice[iaka];
        }
    }

    private static int solve(int sum) {
        if (sum == 0) return 0;
        if (sum < 0) return INF;
        if (mem[sum] != -1) return mem[sum];

        int tsol = INF;
        int marginalCoin = -1;
        for (int i = coins.length - 1; i >= 0; i--) {
            int solSolved = solve(sum - coins[i]) + 1;
            if (tsol >= solSolved) {
                tsol = solSolved;
                marginalCoin = coins[i];
            }
        }
        mem[sum] = tsol;
        choice[sum] = marginalCoin;
        return mem[sum];
    }


}
