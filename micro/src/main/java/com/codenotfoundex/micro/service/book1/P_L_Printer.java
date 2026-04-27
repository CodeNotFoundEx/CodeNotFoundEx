package com.codenotfoundex.micro.service.book1;


import java.util.StringTokenizer;

public class P_L_Printer {
    static void main() {
//        String text = "dddccbdbababaddcbcaabdbdddcccddbbaabddb";
        String text = "abca";
        System.out.println(strangePrinter(text));
    }

    public static int strangePrinter(String s) {
        if (hasOnlyOneChar(s)) {
            return 1;
        }
        char c1 = s.charAt(0);
        char c2 = s.charAt(s.length() - 1);
        StringTokenizer stringTokenizer;
        if (c1 == c2) {
            stringTokenizer = new StringTokenizer(s, String.valueOf(c1));
        }
        else {
            c1 = findLongestSequence(s);
            System.out.println("Longest char: " + c1);
            stringTokenizer = new StringTokenizer(s, String.valueOf(c1));
        }

        int sum = 1;
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            System.out.println("token: " + token);
            if (!token.isEmpty()) {
                sum +=  strangePrinter(token);
            }
        }
        return sum;
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
