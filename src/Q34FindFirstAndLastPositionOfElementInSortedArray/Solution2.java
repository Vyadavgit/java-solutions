package Q34FindFirstAndLastPositionOfElementInSortedArray;
/*
[Facebook]
Q34. Find First and Last Position of Element in Sorted Array
* Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
*
* Example 1:
* Input: nums = [5,7,7,8,8,10], target = 8
  Output: [3,4]
*  */
class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if(nums == null || nums.length == 0){
            return ans;
        }
        int start = 0;
        int end = nums.length-1;
        ans[0] = searchLeft(nums, start, end, target);
        ans[1] = searchRight(nums, start, end, target);
        return ans;
    }

    public int searchLeft(int[] nums, int start, int end, int target){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start)/2;

        if(nums[mid] == target){
            if(mid == 0 || nums[mid-1] < target){
                return mid;
            }else{
                return searchLeft(nums, start, mid-1, target);
            }
        }else if(nums[mid] > target){
            return searchLeft(nums, start, mid-1, target);
        }else{
            return searchLeft(nums, mid+1, end, target);
        }
    }

    public int searchRight(int[] nums, int start, int end, int target){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start)/2;

        if(nums[mid] == target){
            if(mid == nums.length-1 || nums[mid+1] > target){
                return mid;
            }else{
                return searchRight(nums, mid+1, end, target);
            }
        }else if(nums[mid] > target){
            return searchRight(nums, start, mid-1, target);
        }else{
            return searchRight(nums, mid+1, end, target);
        }
    }

}
