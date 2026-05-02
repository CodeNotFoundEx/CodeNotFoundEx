package c.prog.ch4;

public class P_Subsequence_Sum_Max {
    static void main() {
        int[] n = new int[50];
        for (int i = 0; i < n.length; i++) {
            n[i] = Math.random() < 0.50 ? (int) (Math.random() * 100) : -(int) (Math.random() * 100);
        }
        System.out.println("The Numbers: ");
        for (int j : n) {
            IO.print(j + ", ");
        }
        findMaxSumSubsequence(n);

    }

    private static void findMaxSumSubsequence(int[] n) {
        int maxSum = 0;
        int gLeft = 0;
        int left = 0;
        int sum = n[0];
        int lg = 0;
        for (int i = 0; i < n.length; i++) {
            if (sum < 0) {
                left = i;
                sum = n[i];
            } else {
                sum += n[i];
            }
            if (sum > maxSum) {
                maxSum = sum;
                gLeft = left;
                lg = i-gLeft+1;
            }
        }
        System.out.println("\nMax Sum: " + maxSum);
        System.out.println("Starting positon: " + gLeft);
        System.out.println("Subsequence: ");
        for (int i = gLeft; i < gLeft+lg; i++) {
            IO.print(n[i] + ", ");
        }

    }

}
