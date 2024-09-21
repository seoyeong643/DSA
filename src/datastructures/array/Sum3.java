package datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i=0; i < nums.length; i++) {
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            int j = i+1;
            int k = nums.length-1;

            while (j<k) {
                int total = nums[i] + nums[j] + nums[k];

                if (total>0) {
                    k--;
                } else if (total<0) {
                    j++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    while (nums[j] == nums[j-1] && j<k) {
                        j++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int [] nums = {-1,0,1,2,-1,-4};
        int [] nums2 = {0,1,1};
        System.out.println(threeSum(nums));
    }
}
