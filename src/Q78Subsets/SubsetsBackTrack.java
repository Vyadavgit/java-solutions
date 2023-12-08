package Q78Subsets;

//Given an integer array nums of unique elements, return all possible
//        subsets
//        (the power set).
//
//        The solution set must not contain duplicate subsets. Return the solution in any order.
//        Example 1:
//
//        Input: nums = [1,2,3]
//        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

import java.util.ArrayList;
import java.util.List;

// 78. Subsets
// Given an integer array nums of unique elements, return all possible
// subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.
//Example 1:
//
//        Input: nums = [1,2,3]
//        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

// Time complexity : O(2^n)
// Space complexity: O(n*2^n)
public class SubsetsBackTrack {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int index = 0;
        backTrack(nums, new ArrayList<>(), list, index);
        return list;
    }

    public static void backTrack(int[] nums, List<Integer> tempList, List<List<Integer>> list, int index){

        // add subsets to the list
        list.add(new ArrayList<>(tempList));

        for(int i = index; i < nums.length; i++){
            tempList.add(nums[i]);

            backTrack(nums, tempList, list, i + 1);

            // back track
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
