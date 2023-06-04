package Q268MissingNumber;
/*
* Amazon asked
* Q268. Missing Number
* Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
* Example 1:
* Input: nums = [3,0,1]
    Output: 2
    Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
* */

class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 0, 1};
        System.out.println(missingNumber(arr));
    }


    public static int missingNumber(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] < nums.length && nums[i] != i){
                swap(nums, i, nums[i]);
            }else {
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j){
                return j;
            }
        }

        return nums.length;
    }

    public static void swap(int[] nums, int x, int y){
        int temp = nums[y];
        nums[y] = nums[x];
        nums[x] = temp;
    }
}