package c.prog;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Knapsack_P_R {
    static int[][] dp;
    static void main() {
        int[] weights = { 3, 1, 2, 2, 3};
        int[] values = { 9, 4, 8, 10, 11 };
        int capacity = 8;

        dp = new int[weights.length+1][capacity + 1];
        for (int i = 0; i < weights.length+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < weights.length+1; i++) {
            dp[i][0] =0; // if capacity is 0;
        }

        int index = 0;
        int maxValue = knapsack(weights, values, capacity, index);
        System.out.println("Maximum value in Knapsack = " + maxValue);

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.printf("%3d ", dp[i][j]);
            }
            System.out.println();
        }
    }

    private static int knapsack(int[] weights, int[] values, int capacity, int i) {
        if (i == weights.length || capacity <=0) {
            if (capacity<=0) System.out.println("Capacity is full");
            if (i == weights.length) System.out.println("No more items to add");
            return dp[i][capacity]= 0;
        };

        if(dp[i][capacity]!=-1) return dp[i][capacity];

        if (capacity >= weights[i]){
            int t = values[i] + knapsack(weights, values, capacity - weights[i], i+1);
            int nt = knapsack(weights, values, capacity, i+1);
            return dp[i][capacity] = Math.max(t, nt);

        }
        return dp[i][capacity] = knapsack(weights, values, capacity, i+1);
    }
}
