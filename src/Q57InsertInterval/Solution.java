package Q57InsertInterval;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Q57. Insert Interval
//You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
//
//        Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
//        Return intervals after the insertion.
//
//        Example 1:
//
//        Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//        Output: [[1,5],[6,9]]

// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newIntervals = new int[]{4,8};
        Arrays.asList(insert(intervals, newIntervals)).forEach(e-> System.out.print(Arrays.toString(e)+","));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new LinkedList<>();
        int i = 0;

        // add all intervals before newInterval begins
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        // merge all overlapping intervals to one newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // add merged intervals
        res.add(newInterval);

        // add rest
        while (i < intervals.length){
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}