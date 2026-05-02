package com.codenotfoundex.micro.service.jdk25;

public class TheaterChairsProblem {
    static void main() {

        Integer budget = Integer.decode(IO.readln("Enter your budget: "));
        Integer userInputNumber = Integer.decode(IO.readln("Enter a number: "));
        int[] prices = new int[userInputNumber];
        for (int i = 0; i < userInputNumber; i++) {
            prices[i] = Integer.decode(IO.readln("Enter price price[" + (i) + "]: "));
        }

        System.out.println("Max sequence: " + maxSequence(prices, budget));
    }
    record Response(int left, int right, int sum, int max){}

    static Response maxSequence(int[] prices, int budget) {
        int max = 0;
        int currentSum = 0;
        int bestLeft = 0;
        int bestRight = 0;
        int bestSum = 0;
        int left = 0;

        for (int right = 0; right < prices.length; right++) {
            currentSum += prices[right];

            while (currentSum > budget && left <= right) {
                currentSum -= prices[left];
                left++;
            }

            int currentLength = right - left + 1;
            if (currentLength > max) {
                max = currentLength;
                bestLeft = left;
                bestRight = right;
                bestSum = currentSum;
            }
        }
        System.out.println("Max sum: " + bestSum);
        System.out.println("Budget: " + budget);

        return new Response(bestLeft, bestRight, bestSum, max);
    }
}
