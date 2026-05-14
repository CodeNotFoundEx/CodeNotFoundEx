package c.prog.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sort_Util {
    static void main() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] index = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            index[i] = i;
        }
//        int[] ints = sortQuick(arr);
//        System.out.println("Sorted array: " + Arrays.toString(ints));

        List<Pair> collect = IntStream.range(0, arr.length)
                .mapToObj(i -> new Pair(i, arr[i]))
                .sorted(Comparator.comparingInt(Pair::value))
                .peek(p -> System.out.println("Sorting: Index: " + p.index + ", Value: " + p.value))

                .collect(Collectors.toList());
        collect.stream().forEach(p -> System.out.println("Index: " + p.index + ", Value: " + p.value));

    }
    record Pair(int index, int value) {}

    public static int[] sortQuick(int[] arr){
        return sortQuick(arr, 0, arr.length-1);
    }

    private static int[] sortQuick(int[] arr, int left, int right) {
        if(left >= right){
            return arr;
        }
        int position = partition(arr, left, right);
        sortQuick(arr, left, position - 1);
        sortQuick(arr, position + 1, right);
        return arr;
    }
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }
    private static void swap(int[] arr, int i, int j) {
        if( i==j ) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + ", ");
        }
        System.out.println();
    }
}
