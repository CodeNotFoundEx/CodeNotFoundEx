package leet;

public class LongestStringPalindrome {

    static int[] dp;
    static int[] iv;
    static int[] jv;
    static void main() {
        String s = "yacabacax";
        System.out.println(s);
        System.out.println(longestPalindrome(s));

        for (int i = 0; i <s.length(); i++) {
                System.out.println(dp[i] + " " + iv[i] + " " + jv[i]);
        }



    }

    public static String longestPalindrome(String s){
        char[] letters = s.toCharArray();
        int len = s.length();
        dp = new int[len];
        iv = new int[len];
        jv = new int[len];

        for (int i = 0; i < len; i++) {
            fR(letters, i, i, i);
        }

        int index = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] > dp[index]) {
                index = i;
            }
        }
        return s.substring(iv[index], jv[index]+1);

    }

    public static boolean fR(char[]  letters, int left, int right, int index){
        int len = right - left + 1;
        if (len == 1) {
            if(dp[index]<1) dp[index] = 1;
            iv[index] = left;
            jv[index] = right;
        }
        if(isPaliMarginal(letters, left-1, right+1)) {
            if(dp[index]<len+2) dp[index] = len + 2;
            iv[index] = left-1;
            jv[index] = right+1;
            return fR(letters, left-1, right+1, index);
        }
        if(isPaliSide(letters, left-1, right)) {
            if(dp[index]<len+1) dp[index] = len + 1;
            iv[index] = left-1;
            jv[index] = right;
            return fR(letters, left-1, right, index);
        }
        if (isPaliSide(letters, left, right+1)) {
            if(dp[index]<len+1) dp[index] = len + 1;
            iv[index] = left;
            jv[index] = right+1;
            return fR(letters, left, right+1, index);
        }
        return false;

    }




    public static boolean isPaliMarginal(char[] letters, int i, int j){
        if (i < 0 || j > letters.length - 1) return false;
        return letters[i]==letters[j];
    }

    public static boolean isPaliSide(char[] letters, int i, int j){
        if (i < 0 || j > letters.length - 1) return false;
        while (i<j) if(letters[i++]!=letters[j--]) return false;
        return true;
    }




}
