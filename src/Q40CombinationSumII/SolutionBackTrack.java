package Q40CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 40. Combination Sum II

//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//
//        Each number in candidates may only be used once in the combination.
//
//        Note: The solution set must not contain duplicate combinations.
//
//Example 1:
//
//        Input: candidates = [10,1,2,7,6,1,5], target = 8
//        Output:
//        [
//        [1,1,6],
//        [1,2,5],
//        [1,7],
//        [2,6]
//        ]

public class SolutionBackTrack {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, new ArrayList<>(), list, target, 0);
        return list;
    }

    private static void backTrack(int[] candidates, List<Integer> tempList, List<List<Integer>>list, int remain, int index){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = index; i < candidates.length; i++){
                if(i > index && candidates[i] == candidates[i-1]) continue;
                tempList.add(candidates[i]);
                backTrack(candidates, tempList, list, remain - candidates[i], i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
