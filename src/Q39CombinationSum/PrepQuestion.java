package Q39CombinationSum;

import java.util.ArrayList;
import java.util.List;

import static Q39CombinationSum.Bruteforce_vk39.subsets;

// Printing all subsets using Backtracking:
// Print all subsets of a given Set or Array
//Given an array Arr[] of size N, print all the subsets of the array.
//
//        Subset: A subset of an array is a tuple that can be obtained from the array by removing some (possibly all) elements of it
//
//        Example:
//
//        Input: N = 3, Arr = [1, 2, 3]
//        Output: {}
//        {1}
//        {1, 2}
//        {1, 2, 3}
//        {1, 3}
//        {2}
//        {2, 3}
//        {3}
//        Explanation: These are all the subsets that can be formed from the given array, it can be proven that no other subset exists other than the given output.
public class PrepQuestion {
    public static void calcSubset(List<Integer> A, List<List<Integer>> res, List<Integer> subset, int index){

        // keep adding the subsets
        res.add(new ArrayList<>(subset));

        for(int i = index; i < A.size(); i++){

            // for each index value add a subset during each recursive call
            subset.add(A.get(i));

            // recursive calls for each index value
            calcSubset(A, res, subset, i+1);

            // backtrack
            subset.remove(subset.size() - 1);
        }
    }

    public static List<List<Integer>> subsets(List<Integer> A){
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int index = 0;
        calcSubset(A, res, subset, index);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> array = List.of(1, 2, 3);
        List<List<Integer>> res = subsets(array);

        for (List<Integer> subset : res){
            for(Integer num : subset){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
