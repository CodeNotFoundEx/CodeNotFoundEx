package com.codenotfoundex.micro.service.book1;

public class P38_SumaProdus {
    static void main() {
        String readln = IO.readln("Enter n: ");
        int n = Integer.decode(readln);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.decode(IO.readln("Enter arr[" + i + "]: "));
        }
        //print them
        for (int i = 0; i < n; i++) {
            IO.println("arr[" + i + "] = " + arr[i]);
        }
    }
}
