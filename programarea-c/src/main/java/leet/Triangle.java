package leet;

import java.util.Arrays;
import java.util.List;

public class Triangle {
    static int n;
    static int[][] dp;

    static void main() {
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3,4),
                Arrays.asList(6,5,7),
                Arrays.asList(4,1,8,3)
        );
        System.out.println(minimumTotal(triangle));

    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        dp = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-10);
        // dp[0][0]=triangle.get(0).get(0);
        // dp[1]=dp[0]+Math.min(triangle.get(1).get(0),triangle.get(1).get(1));
        return minTotalR(triangle, 0, 0);
    }

    public static int minTotalR(List<List<Integer>> triangle, int index, int depth){
        if(depth==n) return 0;
        if(dp[depth][index]!=-10) return dp[depth][index];
        return dp[depth][index] = triangle.get(depth).get(index) + Math.min(
                minTotalR(triangle, index, depth+1),
                minTotalR(triangle, index+1, depth+1));
    }
}
