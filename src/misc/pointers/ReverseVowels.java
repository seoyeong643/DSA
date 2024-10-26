package misc.pointers;

public class ReverseVowels {
    // Two pointers
    public static String reverseVowels(String s) {
        int l=0;
        int r=s.length()-1;
        char[] chars = s.toCharArray();
        while(l<r){
            if(!vowel(chars[l])) l++;
            if(!vowel(chars[r])) r--;
            if(vowel(chars[l]) && vowel(chars[r])){
                char temp = chars[r];
                chars[r] = chars[l];
                chars[l] = temp;
                l++;
                r--;
            }
        }
        return new String(chars);
    }
    public static boolean vowel(char c){
        char cc = Character.toLowerCase(c);
        if(cc=='a' | cc=='e' | cc=='i' | cc=='o' | cc=='u') return true;
        return false;
    }

    public static void main(String[] args){
        String s1 = "IceCreAm";
        String s2 = "leetcode";
        String s3 = "race car";
        System.out.println(reverseVowels(s1));
        System.out.println(reverseVowels(s2));
        System.out.println(reverseVowels(s3));
    }
}
