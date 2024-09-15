package misc.leetcode;

import java.util.*;

public class Anagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Create a hash map to store  sorted words: keys, and lists of anagrams: values
        Map<String, List<String>> map = new HashMap<>();

        for(String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            // Convert the sorted character array back to a string
            String sortedWord = String.valueOf(chars);

            if(!map.containsKey(sortedWord)){
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs1 = {""};
        System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagrams(strs1));
    }
}
