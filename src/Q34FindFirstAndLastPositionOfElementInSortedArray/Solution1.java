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
class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if(nums == null || nums.length == 0){
            return ans;
        }
        int start = 0;
        int end = nums.length-1;
        ans[0] = search(nums, start, end, target, true);
        ans[1] = search(nums, start, end, target, false);
        return ans;
    }

    public int search(int[] nums, int start, int end, int target, boolean firstIndex){
        int index = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                index = mid;
                if(firstIndex){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return index;
    }
}
