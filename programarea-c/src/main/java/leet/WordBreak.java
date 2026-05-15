package leet;

import java.util.*;
import java.util.stream.Collectors;

public class WordBreak {

    static void main() {
        IO.println("Hello World");
        String s= "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> strings = List.of("a","ab", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");

        System.out.println(wordBreak(s, strings));
    }


    static TreeMap<String, String> dict = new TreeMap<>();
    static HashSet<String> dictSet = new HashSet<>();
    public static boolean wordBreak(String s, List<String> wordDict) {
        sanity(new HashSet<>(s.chars().mapToObj(c -> (char) c).toList()),
                wordDict.stream().flatMap(w -> w.chars().mapToObj(c -> (char) c))
                        .collect(Collectors.toSet()));


        dict.putAll(wordDict.stream()
                .collect(TreeMap::new, (m, v) -> m.put(v, v), TreeMap::putAll));
        dictSet.addAll(wordDict);
        return wordBreak(s, dict);
    }
    public static boolean wordBreak(String s, TreeMap<String, String> dict){
        if(dictSet.contains(s)) return true;
//        String floorKey = dict.floorKey(s);
        NavigableMap<String, String> stringStringNavigableMap = dict.headMap(s, true);
        if(stringStringNavigableMap.size()==0) return false;

        int count = 0;
        for (String key : stringStringNavigableMap.descendingKeySet()) {
            count++;
            if(count>3) return false;
            if(s.startsWith(key)) {
                String newS = s.substring(key.length());
                if(wordBreak(newS, dict)) return true;
            }
        }
        return false;
    }

    public static boolean sanity(Set<Character> word, Set<Character> omega) {
        return omega.containsAll(word);
    }
}
