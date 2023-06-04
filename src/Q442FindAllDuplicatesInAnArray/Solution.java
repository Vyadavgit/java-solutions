package Q442FindAllDuplicatesInAnArray;

import java.util.ArrayList;
import java.util.List;

/*
* Q442. Find All Duplicates in an Array
* Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
You must write an algorithm that runs in O(n) time and uses only constant extra space.
* Example 1:
* Input: nums = [4,3,2,7,8,2,3,1]
  Output: [2,3]
* */
class Solution {
    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            }else{
                i++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j+1){
                res.add(nums[j]);
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