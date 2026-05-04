package c.prog;

import java.util.Arrays;

public class Knapsack_P_R {
    static int[][] dp;
    static int[][] keep;
    static int[] path;

    public static void main(String[] args) {
        int[] weights = { 3, 1, 2, 2};
        int[] values = { 15, 4, 8, 10 };
        int capacity = 5;

        dp = new int[weights.length + 1][capacity + 1];
        keep = new int[weights.length + 1][capacity + 1];
        path = new int[weights.length + 1];
        for (int i = 0; i < weights.length + 1; i++) {
            Arrays.fill(dp[i], -1);
            Arrays.fill(keep[i], 0);
            path[i] = -1;
        }

        int index = 0;
        int maxValue = knapsack(weights, values, capacity, index);
        System.out.println("Maximum value in Knapsack = " + maxValue);

        // Reconstruct path
        int tempCap = capacity;
        for (int i = 0; i < weights.length; i++) {
            if (keep[i][tempCap] == 1) {
                path[i] = 1;
                tempCap -= weights[i];
            } else {
                path[i] = 0;
            }
        }
        path[weights.length] = 0; // base case

        printMatrix(dp);


        //print paths
        System.out.print("Path: ");
        for (int i = 0; i < path.length-1; i++) {
            System.out.printf("%2d ", path[i]);
        }
        System.out.println();
        printMatrix(keep);
    }

    private static void printMatrix(int[][] matrix) {
        //print DP
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int knapsack(int[] weights, int[] values, int capacity, int i) {

        if (i == weights.length || capacity <= 0) {
            if (i <= weights.length && capacity >= 0) {
                dp[i][capacity] = 0;
            }
            return 0;
        }
        if (dp[i][capacity] != -1) return dp[i][capacity];


        if (capacity >= weights[i]) {
            int t = values[i] + knapsack(weights, values, capacity - weights[i], i + 1);
            int nt = knapsack(weights, values, capacity, i + 1);
            keep[i][capacity] = t > nt ? 1:0;
            return dp[i][capacity] = Math.max(t, nt);
        }
        keep[i][capacity] = 0;
        return dp[i][capacity] = knapsack(weights, values, capacity, i + 1);
    }
}
