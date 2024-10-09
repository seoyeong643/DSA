package algorithms.greedy;

public class Swaps {
    public static int minSwaps(String s) {
        int open = 0;  // count of unmatched '['
        int close = 0; // count of unmatched ']'

        for (char c : s.toCharArray()) {
            if (c == '[') {
                open++;
            } else {
                if (open > 0) {
                    open--; // pair this ']' with a '['
                } else {
                    close++; // unmatched ']'
                }
            }
        }

        // Each swap fixes 2 unmatched brackets -> (close+1)/2 swaps
        return (close+1)/2;
    }

    public static void main(String[] args){
        String s1 = "][][";
        String s2 = "]]][[[";
        String s3 = "[]";
        String s4 = "]][[[]]][[]][][[";
        System.out.println(minSwaps(s1));
        System.out.println(minSwaps(s2));
        System.out.println(minSwaps(s3));
        System.out.println(minSwaps(s4));
    }
}
