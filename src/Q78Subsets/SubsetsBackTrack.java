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

public class SubsetsBackTrack {
    public List<List<Integer>> subsets(int[] nums) {
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
}
