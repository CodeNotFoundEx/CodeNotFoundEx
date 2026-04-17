package com.codenotfoundex.micro.service.book1;

public class P36_Expresii {
    static void main() {
        System.out.println(e1(12, 3.14));
    }

    private static double e1(int n, double x) {
        long numitor = 1;
        double numarator = x;
        int sign = 1;
        double sum = x;
        for (int i = 3; i < n; i=i+2) {
            sign *= -1;
            numitor *= i*(i-1);
            numarator *= x*x;
            sum += sign * numarator / numitor;
        }
        return sum;
    }
}
