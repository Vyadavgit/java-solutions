package Q448FindAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.List;

/* Google asked
* Q448. Find All Numbers Disappeared in an Array
* Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
* Example 1:
* Input: nums = [4,3,2,7,8,2,3,1]
  Output: [5,6]
* */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int i = 0;
        while(i < nums.length){
            if(nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            }else{
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j+1){
                res.add(j+1);
            }
        }
        return res;
    }

    public static void swap(int[] nums, int x, int y){
        int temp = nums[y];
        nums[y] = nums[x];
        nums[x] = temp;
    }
}