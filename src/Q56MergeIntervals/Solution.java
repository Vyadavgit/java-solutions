package Q56MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Q56. Merge Intervals
//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of
//the non-overlapping intervals that cover all the intervals in the input.
//
//        Example 1:
//
//        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//        Output: [[1,6],[8,10],[15,18]]
//        Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].


//Time Complexity: O(n log n)
//Space Complexity: O(n)
class Solution {
    public static void main(String[] args) {
        int[][] list = new int[][]{{1,4},{0,0}};
        System.out.println(Arrays.deepToString(merge(list)));
    }

    public static int[][] merge(int[][] intervals) {

        if (intervals == null) return null;

        // sort the 2D array
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

//        System.out.println(Arrays.deepToString(intervals));

        int[] prev = intervals[0];
        List<int[]> merge = new ArrayList<>();

        for(int i = 1; i <= intervals.length; i++){
            if(i < intervals.length && prev[1] >= intervals[i][0]){
                prev[1] = Math.max(prev[1], intervals[i][1]);
            }else {
                merge.add(prev);
                if (i < intervals.length) prev = intervals[i];
            }
        }

        return merge.toArray(new int[0][]);
    }
}
