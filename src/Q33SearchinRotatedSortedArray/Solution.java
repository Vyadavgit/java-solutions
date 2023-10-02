package Q33SearchinRotatedSortedArray;

/*
*
* 33. Search in Rotated Sorted Array
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.
* Example 1:
* Input: nums = [4,5,6,7,0,1,2], target = 0
  Output: 4
* */

// Time Complexity: O(log n)
// Space Complexity: O(log n)
class Solution {
    public int search(int[] nums, int target) {
        return findpivot(nums, target, 0, nums.length-1);
    }

    private int findpivot(int[] nums, int target, int s, int e){
        if(s > e){
            return -1;
        }

        int m = s + (e - s)/2;

        if(target == nums[m]){
            return m;
        }

        if(nums[s] <= nums[m]){
            if(target >= nums[s] && target <= nums[m]){
                return findpivot(nums, target, s, m-1);
            }else{
                return findpivot(nums, target, m+1, e);
            }
        }

        if(target >= nums[m] && target <= nums[e]){
            return findpivot(nums, target, m+1, e);
        }

        return findpivot(nums, target, s, m-1);
    }
}