package c.prog.ch4.book1;


import java.util.StringTokenizer;

public class P_L_Printer2 {

    private static int[] letters = new int[27];

    static void main() {
//        String text = "dddccbdbababaddcbcaabdbdddcccddbbaabddb";
//        String text = "ccdaccacbbdbacdccdbadacbbcbbaadacbadadbbcbdbaacdb";
//        String text = "abca";
//        String text = "nwlrbbmqbh";
//        String text = "tbgtgb";
//        String text = "abdaacbadbdcbdbdaadbcadadccdaaadcb";
        String text = "abcabc";
        String x = stripContinuousRepeatingChars(text);
        System.out.println(x);
        countChars(x);

        System.out.println(strangePrinter(x));
    }

    public static int strangePrinter(String s) {
        return strangePrinterDP(stripContinuousRepeatingChars(s));
    }

    public static int strangePrinterDP(String s) {
        if (hasOnlyOneChar(s)) {
            return 1;
        }
        int strategy1 = Integer.MAX_VALUE;
        int strategy2 = Integer.MAX_VALUE;
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            strategy1 = 1 + strangePrinter(s.substring(1, s.length() - 1));
            StringTokenizer stringTokenizer;
            stringTokenizer = new StringTokenizer(s, String.valueOf(s.charAt(0)));
            strategy2 = 1;
            while (stringTokenizer.hasMoreTokens()) {
                String token = stringTokenizer.nextToken();
//                System.out.println("token: " + token);
                if (!token.isEmpty()) {
                    strategy2 += strangePrinter(token);
                }
            }
            return Math.min(strategy1, strategy2);

        } else {
            boolean found = false;
            int i = 0;
            int lastIndexOfFirstChar = 0;
            for (; i < s.length()-1 && !found; i++) {
                lastIndexOfFirstChar = findLastIndexOfChar(s, i);
                if (lastIndexOfFirstChar != i) {
                    found = true;

                }
            }
            if(found && i==0){
                strategy2 = 1 + strangePrinter(s.substring(0, lastIndexOfFirstChar)) + strangePrinter(s.substring(lastIndexOfFirstChar));
            } else if (found && i>0) {
                strategy2 = strangePrinter(s.substring(i, lastIndexOfFirstChar)) + strangePrinter(s.substring(0,i))
                + strangePrinter(s.substring(lastIndexOfFirstChar));
            } else {
                strategy2 = strangePrinter(s.substring(1)) + 1;
            }
            return strategy2;
        }
    }

    private static String stripContinuousRepeatingChars(String s) {
        StringBuilder sb = new StringBuilder();
        char lastChar = s.charAt(0);
        sb.append(lastChar);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != lastChar) {
                sb.append(s.charAt(i));
                lastChar = s.charAt(i);
            }
        }
        return sb.toString();
    }

    private static int findLastIndexOfChar(String s, int i){
        for (int j = s.length() - 1; j > i; j--) {
            if (s.charAt(j) == s.charAt(i)) {
                return j;
            }
        }
        return i;
    }





    private static void countChars(String s) {
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }

    }

    private static char findLongestSequence(String s) {
        //find the longest sequence of characters in the string and return the character
        char longestChar = s.charAt(0);
        int longestLength = 1;
        int currentLength = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentLength++;
            } else {
                if (currentLength > longestLength) {
                    longestLength = currentLength;
                    longestChar = s.charAt(i - 1);
                }
                currentLength = 1;
            }
        }
        if (currentLength > longestLength) {
            longestLength = currentLength;
            longestChar = s.charAt(s.length() - 1);
        }
        return longestChar;

    }


    private static boolean hasOnlyOneChar(String str) {
        char first = str.charAt(0);
        return str.chars().allMatch(c -> c == first);
    }


}
