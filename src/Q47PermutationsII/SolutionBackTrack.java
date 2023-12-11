package Q47PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 47. Permutations II
// Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
//Example 1:
//
//        Input: nums = [1,1,2]
//        Output:
//        [[1,1,2],
//        [1,2,1],
//        [2,1,1]]

// Time complexity: O(N * N!)
// Space complexity: O(N * N!)

public class SolutionBackTrack {
    public static void main(String[] args) {
        List<List<Integer>> list = permuteUnique(new int[]{1,1,2});
        System.out.println(list);
    }

    public static List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, new ArrayList<>(), list, new boolean[nums.length]);
        return list;
    }

    private static void backTrack(int[] nums, List<Integer> tempList, List<List<Integer>> list, boolean[] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        }else {
            for (int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backTrack(nums, tempList, list, used);
                used[i] = false;
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
