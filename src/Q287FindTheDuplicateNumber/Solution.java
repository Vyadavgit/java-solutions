package Q287FindTheDuplicateNumber;
/* Microsoft, Amazon asked
* Q287. Find the Duplicate Number
* Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.
* Example 1:
* Input: nums = [1,3,4,2,2]
  Output: 2
* */
class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] != i+1){
                if(nums[nums[i]-1] == nums[i]){ // if swap positions have same value
                    return nums[i];
                }
                swap(nums, nums[i]-1, i);
            }else{
                i++;
            }
        }
        return -1;
    }

    public void swap(int[] nums, int x, int y){
        int temp = nums[y];
        nums[y] = nums[x];
        nums[x] = temp;
    }
}