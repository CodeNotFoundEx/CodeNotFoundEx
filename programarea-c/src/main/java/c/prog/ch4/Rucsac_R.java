package c.prog.ch4;

import java.util.Arrays;

public class Rucsac_R {
    static int[][] dp;
    static int[][] keep;

    static void main() {
        int[] weights = {3, 1, 2, 2};
        int[] values = {15, 7, 8, 10};
        int capacity = 7;

        dp = new int[weights.length][capacity + 1];
        keep = new int[weights.length][capacity + 1];
        for (int i = 0; i < weights.length; i++) {
            Arrays.fill(dp[i], -1);
            Arrays.fill(keep[i], 0);
        }

        int maxValue = knapsack(weights, values, capacity, 0);
        System.out.println("Maximum value in Knapsack = " + maxValue);
        printMatrix(dp);
        printMatrix(keep);

        int[] path = new int[weights.length];
        int tempCap = capacity;
        for (int i = 0; i < weights.length; i++) {
            if (keep[i][tempCap] == 1) {
                path[i] = 1;
                tempCap -= weights[i];
            } else {
                path[i] = 0;
            }
        }
        System.out.println();
        for (int i = 0; i <path.length; i++) {
            System.out.printf("%2d ", path[i]);
        }
    }

    static int knapsack(int[] weights, int[] values, int capacity, int index) {
        if (index == weights.length || capacity <= 0) {
            return 0;
        }
        if (dp[index][capacity] != -1) {
            return dp[index][capacity];
        }
        if (weights[index] <= capacity) {
            int take = values[index] + knapsack(weights, values, capacity - weights[index], index + 1);
            int notTake = knapsack(weights, values, capacity, index + 1);
            keep[index][capacity] = take > notTake ? 1 : 0;
            return dp[index][capacity] = Math.max(take, notTake);
        }
        keep[index][capacity] = 0;
        return dp[index][capacity] = knapsack(weights, values, capacity, index + 1);
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
