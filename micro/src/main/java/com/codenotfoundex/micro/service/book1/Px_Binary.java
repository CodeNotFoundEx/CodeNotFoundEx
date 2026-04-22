package com.codenotfoundex.micro.service.book1;

public class Px_Binary {
    static void main() {
        int n = Integer.decode(IO.readln("Enter the length of the array: "));
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.decode(IO.readln("Enter a[" + i + "]: "));
        }

//        swapArr(a, 1, 3);
        int binary = findBinary(a, 5);
        System.out.println("Found at index: " + binary);
        printArray(a);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            IO.print(arr[i] + ", ");
        }
    }

    private static void swapArr(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int findBinary(int[] arr, int x){
        return find(arr, x, 0, arr.length-1);
    }

    private static int find(int[] arr, int x, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;
    }
}
