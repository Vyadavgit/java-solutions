package Q53MaximumSubarray;

// Q53. Maximum Subarray
// Given an integer array nums, find the subarray with the largest sum, and return its sum.
//Example 1:
//
//        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//        Output: 6
//        Explanation: The subarray [4,-1,2,1] has the largest sum 6.

// Kadane's algorithm
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0]; // hold the max sum
        for(int i = 1; i < nums.length; i++){
            sum = Math.max(sum + nums[i], nums[i]); // set sum to new nums[i] if it is greater or hold fluctuating sum based on nums[i] values smaller than sum.
            max = Math.max(sum, max);
        }
        return max;
    }
}