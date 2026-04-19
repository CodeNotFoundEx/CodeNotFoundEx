package com.codenotfoundex.micro.service.book1;

import java.util.Map;
import java.util.TreeMap;

public class Px1_RomanNumbers_RedBlackTree {
    static TreeMap<Integer, String> treeMap = new TreeMap<>();
    static void main() {

        treeMap.put(1, "I");
        treeMap.put(4, "IV");
        treeMap.put(5, "V");
        treeMap.put(9, "IX");
        treeMap.put(10, "X");
        treeMap.put(40, "XL");
        treeMap.put(50, "L");
        treeMap.put(90, "XC");
        treeMap.put(100, "C");
        treeMap.put(400, "CD");
        treeMap.put(500, "D");
        treeMap.put(900, "CM");
        treeMap.put(1000, "M");


        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        Map.Entry<Integer, String> entry = treeMap.floorEntry(num);

        if (entry.getKey() == num) {
            return entry.getValue();
        }
        return entry.getValue() + intToRoman(num - entry.getKey());
    }
}
