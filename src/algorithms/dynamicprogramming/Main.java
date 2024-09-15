package algorithms.dynamicprogramming;

public class Main {
    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();

        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

//        int maxSum = slidingWindow.findMaxSumSubarray(arr, k);
//        System.out.println("Maximum sum of a subarray of size " + k + " is: " + maxSum);


        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(slidingWindow.maxSubArray(nums));
    }
}
