package com.codenotfoundex.micro.service.book1;

import java.util.List;

public class Px2_Coins_DP {
    static int[] mem;
    static List<Integer> coins = List.of(1, 5, 7, 13);
    static int[] solutions = new int[coins.stream().mapToInt(i -> i).max().orElseThrow() + 1];


    static void main() {
        int sum = 27;
        for (int i = 0; i < solutions.length; i++) {
            solutions[i] = 0;
        }
        mem = new int[sum + 1];
        for (int i = 1; i < mem.length; i++) {
            mem[i] = -1;
        }
        int solve = solve(sum);
        System.out.println("Minimum number of coins needed: " + solve);
        System.out.println("Coins used:");
        for (int i = 0; i < solutions.length; i++) {
            if (solutions[i] > 0) {
                System.out.println(i + ": " + solutions[i]);
            }
        }
    }

    private static int solve(int sum) {
        if (sum == 0) return 0;
        if (sum < 0) return Integer.MAX_VALUE - 100;
        if (mem[sum] != -1) return mem[sum];

        int temp = Integer.MAX_VALUE - 100;
        int tc = 0;
        for (int coin : coins) {
            solutions[coin]+=1;

            int currentSolution = solve(sum - coin) + 1;
            if (currentSolution <= temp){
                temp = currentSolution;
                tc = coin;
            }
            solutions[tc]-=1;
//            temp = Math.min(temp, currentSolution);
        }
        mem[sum] = temp;

        return mem[sum];

    }


}
