package Q41FirstMissingPositive;

/* Amazon asked
* Q41. First Missing Positive
* Given an unsorted integer array nums, return the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time and uses constant extra space.
* Example 1:
* Input: nums = [1,2,0]
  Output: 3
  Explanation: The numbers in the range [1,2] are all in the array.
* */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correctPos = nums[i] - 1;
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctPos]){
                swap(nums, i, correctPos);
            }else{
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j+1){
                return j+1;
            }
        }

        return nums.length + 1;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
