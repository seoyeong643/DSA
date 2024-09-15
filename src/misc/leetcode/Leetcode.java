package misc.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode {
    public static int firstMissingPositive1(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int x = 0;

        for (int i=0; i<len; i++) {
            if(nums[i]<=0){
                x=i;
                continue;
            }
            // has plus 1 because the numbers start from 1 not 0
            if (i-x+1 != nums[i]) {
                System.out.println("within nums values");
                return i+1;
            }
        }
        System.out.println("not within nums values");
        return len+1;
    }

    public static int firstMissingPositive(int[] nums) {
        // sort the array [3,4,-1,1] -> [-1,1,3,4]
        Arrays.sort(nums);
        int len = nums.length;

        // hashset to store all values in nums array
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<len; i++){
            set.add(nums[i]);
        }
        System.out.println(String.valueOf(set));

//        if(nums[len-1]<=0){
//            return 1;
//        }
//        int i=1;
//        for(i=1; i<nums[nums.length-1]; i++){
//            System.out.println(i);
//            if(!set.contains(i)){
//                System.out.println("within nums values");
//                return i;
//            }
//        }

        for (int i=0; i < len; i++) {
            // has plus 1 because the numbers start from 1 not 0
            if (!set.contains(i)) {
                System.out.println("within nums values");
                return i;
            }
        }
        System.out.println("not within nums values");
        return len+1;
    }


    public static void main(String[] args){
        int[] nums = {1,2,0};
        int[] nums2 = {0};
//        System.out.println(firstMissingPositive(nums));
//        System.out.println();
        System.out.println(firstMissingPositive1(nums));
    }
}
