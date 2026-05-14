package c.prog.jb;

import java.util.Arrays;

public class Solution {
    static void main() {

        String iaka = "\\;\\*;|;;|aa|bbb\n2;*;3;*;4;;5aa7bbb23aa9";
        System.out.println(sumString(iaka));
    }

    static int sumString(String num){
        int indexOfDel =  num.indexOf("\n");
        System.out.println(indexOfDel);

        String delimiters = num.substring(1, indexOfDel);
        System.out.println(delimiters);
        String[] split = num.substring(indexOfDel+1).split(delimiters);

        System.out.println(Arrays.asList(split));
        return 0;
    }




}
