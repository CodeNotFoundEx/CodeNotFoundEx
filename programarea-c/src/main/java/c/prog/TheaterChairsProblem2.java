package c.prog;

import java.util.Arrays;

public class TheaterChairsProblem2 {
    static int[] prices = {4, 4, 4, 2, 2, 2, 1, 1, 1, 1, 1, 1, 100, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4};
    static int[] budgets = new int[prices.length];
    static int[] counts = new int[prices.length];

    static void main() {

        Integer budget = Integer.decode(IO.readln("Enter your budget: "));

//        System.out.println("Max sequence: " + maxSequence(prices, budget));

        int allEncompasingBudget = sumAll(prices, 0, prices.length - 1);
        System.out.println("All encompassing budget: " + allEncompasingBudget);
        budgets[0] = allEncompasingBudget;
        counts[0] = prices.length;
        nextBest(prices, 0, prices.length - 1, 0);

        for (int i = 0; i < budgets.length; i++) {

            System.out.println("Budget: " + budgets[i] + ", count: " + counts[i]);

        }

    }

    static int nextBest(int[] prices, int i, int j, int x) {
        while (i < j && (j - i) > prices.length / 2) {
            if (prices[i] > prices[j]) {
                i++;
                System.out.println("Take left " + i);
                budgets[x++] = sumAll(prices, i, j);
                counts[x - 1] = j - i + 1;
            } else {
                j--;
                System.out.println("Take right " + j);
                budgets[x++] = sumAll(prices, i, j);
                counts[x - 1] = j - i + 1;
            }
        }

        return 0;
    }

    private static int sumAll(int[] prices, int i, int j) {
        return Arrays.stream(prices)
                .skip(i)
                .limit(j - i + 1)
                .sum();
    }

}
