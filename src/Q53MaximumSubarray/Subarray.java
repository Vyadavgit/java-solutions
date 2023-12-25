package Q53MaximumSubarray;

import java.util.Arrays;

// This algorithm displays max value of subArray, start-end indexes of the maxSubArray, and values of maxSubArray.
public class Subarray {
    public static int[] maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0]; // hold the max sum
        int curr_start = 0,curr_end = 0;
        int start = 0, end = 0;
        for(int i = 1; i < nums.length; i++){

//            sum = Math.max(sum+nums[i], nums[i]);
            if(nums[i] > sum+nums[i]){
                sum = nums[i];
                curr_start = i;
                curr_end = i;
            }else {
                sum = sum+nums[i];
                curr_end = i;
            }

//            max = Math.max(sum, max);
            if(sum > max){ // if new sum is greater than previous max reset pointers to the new period
                max = sum;
                start = curr_start;
                end = curr_end;
            }
        }

        return new int[]{start, end, max};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] ans = maxSubArray(nums);
        System.out.println("Sum: "+ ans[2]+", Start-end index: {"+ans[0]+","+ans[1]+"}, Max subarray: "+ Arrays.toString(Arrays.copyOfRange(nums, ans[0], ans[1])));

        nums = new int[]{5,4,-1,7,8};
        ans = maxSubArray(nums);
        System.out.println("Sum: "+ ans[2]+", Start-end index: {"+ans[0]+","+ans[1]+"}, Max subarray: "+ Arrays.toString(Arrays.copyOfRange(nums, ans[0], ans[1])));

    }
}
