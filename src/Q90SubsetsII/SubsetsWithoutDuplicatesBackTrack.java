package Q90SubsetsII;

// 90. Subsets II
//Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
//        The solution set must not contain duplicate subsets. Return the solution in any order.
//
//        Example 1:
//
//        Input: nums = [1,2,2]
//        Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time complexity : O(2^n)
// Space complexity: O(n*2^n)
public class SubsetsWithoutDuplicatesBackTrack {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, new ArrayList<>(), list, 0);
        return list;
    }

    public static void backTrack(int[] nums, List<Integer> tempList, List<List<Integer>> list, int index){
        list.add(new ArrayList<>(tempList)); // add subsets

        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue; // skip duplicates (prereq: sorted arrays)
            tempList.add(nums[i]); // create subsets
            backTrack(nums, tempList, list, i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] {1, 2, 2,}));
    }
}
