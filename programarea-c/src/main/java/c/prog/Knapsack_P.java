package c.prog;

public class Knapsack_P {
    static int[][] dp;
    static void main() {
        int[] weights = { 3, 1, 2, 2};
        int[] values = { 15, 4, 8, 10 };
        int capacity = 5;

        int items = weights.length;
        dp = new int[items + 1][capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            dp[0][i] = 0;
        }

        int maxValue = knapsack(weights, values, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.printf("%3d ", dp[i][j]);
            }
            System.out.println();
        }
    }

    private static int knapsack(int[] weights, int[] values, int capacity) {
        for (int i = 0; i < weights.length; i++) {
            for (int c = 0; c <= capacity; c++) {
                if(c<weights[i]) {dp[i+1][c]=dp[i][c];}
                else {
                    int takeIt = values[i]+dp[i][c-weights[i]];
                    int notTakeIt = dp[i][c];
                    dp[i+1][c] = Math.max(takeIt, notTakeIt);
                }
            }
        }
        return dp[weights.length][capacity];
    }
}
