package Q39CombinationSum;

//Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//        The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
//        frequency
//        of at least one of the chosen numbers is different.
//
//        The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

//Example 1:
//
//        Input: candidates = [2,3,6,7], target = 7
//        Output: [[2,2,3],[7]]
//        Explanation:
//        2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//        7 is a candidate, and 7 = 7.
//        These are the only two combinations.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionBackTrack {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, new ArrayList<>(), list, target, 0);
        return list;
    }

    private static void backTrack(int[] candidates, List<Integer> tempList, List<List<Integer>> list, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < candidates.length; i++){
                tempList.add(candidates[i]);
                backTrack(candidates, tempList, list, remain - candidates[i], i);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}