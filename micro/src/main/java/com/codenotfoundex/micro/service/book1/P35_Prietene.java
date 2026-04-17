package com.codenotfoundex.micro.service.book1;

public class P35_Prietene {
    static void main() {
        System.out.println("Numerele prietene intre 1 si 10000 sunt:");
        for (int i = 1; i < 1000000; i++) {
            int b = sumaDivizorilor(i);
            if (b > i && suntPrietene(i, b)) {
                System.out.println(i + " si " + b);
            }
        }
    }

    static boolean suntPrietene(int a, int b) {
        return sumaDivizorilor(a) == b && sumaDivizorilor(b) == a;
    }

    static int sumaDivizorilor(int n) {
        int sum = 0;
        for (int i = 2; i < (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i;
                sum += (n / i);
            }
        }
        return sum+1;
    }
}
