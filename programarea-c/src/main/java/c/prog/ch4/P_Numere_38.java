package c.prog.ch4;

public class P_Numere_38 {
    static void main() {
        int n = 4;
        boolean done = false;
        int[] nums = new int[3];
        int i = 0;
        while (!done) {
            printArray(nums);
            nums[i]++;
        }

    }

    public static void generate(int[] nums, int index){


    }

    private static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }
}
