package algorithms.greedy;

import java.util.HashMap;
import java.util.Map;

public class Palindrome {
    public static int longestPalindrome(String s) {
        Map<Character, Integer> numChar = new HashMap<>();

        for(char c : s.toCharArray()){
            numChar.put(c, numChar.getOrDefault(c, 0)+1);
        }

        int length=0;
        for(int n : numChar.values()){
            if(n%2==1) length--;
            length+=n;
        }
        return length==s.length() ? length : length+1;
    }

    public static void main(String[] args){
        String s1 = "abccccdd";
        String s2 = "aabbcc";
        String s3 = "AaBbCc";

        // Testing the longestPalindrome method
        System.out.println("Longest Palindrome Length");
        System.out.println(s1 + " | " + longestPalindrome(s1));
        System.out.println(s2 + " | " + longestPalindrome(s2));
        System.out.println(s3 + " | " + longestPalindrome(s3));
    }
}
