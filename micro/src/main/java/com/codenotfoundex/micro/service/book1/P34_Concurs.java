package com.codenotfoundex.micro.service.book1;

public class P34_Concurs {
    static void main() {

        int suc = 5;
        int fail = -3;
        calculate(101, 0, 5);
    }

    private static int calculate(int n, int f, int success) {
        if ((n - f*-3) % success == 0) {
            System.out.println("Success: " + (n - f*-3) / success + " Fail: " + f);
            return 0;
        }
        return calculate(n, f+1, success);
    }
}
