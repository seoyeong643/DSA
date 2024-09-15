package algorithms.dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {

    /**
     * Given an integer array nums, find the subarray with the largest sum, and return its sum.
     *
     *
     * @param nums
     * @return the largest sum of a subarray
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     * O(n)
     *
     * @param s the target
     * @return the length of the longest substring
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        Set<Character> charSet = new HashSet<>();
        String str = "";
        int count = 0;

        for(int right=0; right<s.length(); right++){
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            // maxLen = Math.max(maxLen, right-left+1);
            if (maxLen < right-left+1) {
                maxLen = right-left+1;
                str = charSet.toString();
            }
            System.out.println(charSet.toString() +" "+ left + "-"  + right);
            count++;
        }
        System.out.println(str + count);
        return maxLen;
    }

    /**
     * Given an array of positive integers nums and a positive integer target,
     *  return the minimal length of a subarray whose sum is greater than or equal to target.
     * If there is no such subarray, return 0 instead.
     * O(n)
     *
     * @param target the target
     * @param nums the array
     * @return the minimun length of a subarray who's sum is >= target
     */
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int left = 0;
        int[] subArray = {};

        for (int right=0; right<nums.length; right++){
            windowSum += nums[right];   // expand the window by adding the current element

            // Shrink the window as small as possible while the sum is still greater than or equal to target
            while(windowSum >= target){
                // logs
                subArray = Arrays.copyOfRange(nums, left, right+1);
                System.out.println(Arrays.toString(subArray) + " = " + windowSum);

                minLength = Math.min(minLength, right-left+1);
                windowSum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE? 0 : minLength; // return 0 if no such subarray exists
    }

    /**
     * Finds the maximum sum of a subarray of size k.
     * O(n)
     *
     * @param arr the input array
     * @param k the size of the subarray
     * @return the maximum sum of a subarray of size k
     */
    public int findMaxSumSubarray(int[] arr, int k) {
        int maxSum = 0;
        int windowSum = 0;

        // Calculate the sum of the first window of size k
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        maxSum = windowSum;

        // Slide the window over the array
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
