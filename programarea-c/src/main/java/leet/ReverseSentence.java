package leet;

public class ReverseSentence {
    static void main() {
            String s = "  hello world!  ";
            System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        int len = s.length();
        int j = len - 1;
        int i = len - 1;
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (s.charAt(start) == ' ' && start < len) start++;
        if (start == len) return "";
        while (i > start && j > start) {
            while (s.charAt(j) == ' ' && j > start) j--;
            i = j;
            while (s.charAt(i) != ' ' && i > start) i--;
            if (i == start ) sb.append(s.substring(i, j + 1));
            else sb.append(s.substring(i + 1, j + 1)).append(' ');
            j = i;
        }

        return sb.toString();


    }

}
