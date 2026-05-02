package c.prog.ch4;

public class P_Subsequence_Sum_Max_R {
    static void main() {
        int[] n = new int[10];
        for (int i = 0; i < n.length; i++) {
            n[i] = Math.random() < 0.60 ? (int) (Math.random() * 10) : -(int) (Math.random() * 10);
        }
        System.out.println("The Numbers: ");
        for (int j : n) {
            IO.print(j + ", ");
        }
        findMaxSumSubsequence(n);

    }

    private static void findMaxSumSubsequence(int[] n) {
        int maxSum = findMaxSumSubsequenceR(n, 0, 0);
        System.out.println("\nMax Sum: " + maxSum);
    }

    private static int findMaxSumSubsequenceR(int[] n, int i, int sum) {
        if (i == n.length) {
            return sum + 0;
        }
        int take = 0;
        if(n[i]+sum > 0){
            take = findMaxSumSubsequenceR(n, i + 1, sum + n[i]);
        }
        int startover = findMaxSumSubsequenceR(n, i + 1, 0);
        int cont = Math.max(take, startover);
        return Math.max(cont, sum);
    }

}
