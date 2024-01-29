package Q62UniquePaths;

import java.util.HashMap;
import java.util.Map;

//62. Unique Paths
//        There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
//
//        Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
//
//        The test cases are generated so that the answer will be less than or equal to 2 * 109.

// backTracking approach
// Time complexity: O(mxn)
// Space complexity: O(mxn)
public class Solution {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }

    public static int uniquePaths(int m, int n){
        Map<String, Integer> map = new HashMap<>(); // memorization map
        return backTrack(0,0,m,n,map);
    }

    public static int backTrack(int x, int y, int m, int n, Map<String, Integer> map){
        if(x == m-1 && y == n-1) return 1;

        String key = x + "," + y;

        if (map.containsKey(key)){
            return map.get(key);
        }

        int down = (x == m-1) ? 0 : backTrack(x+1, y, m, n, map);
        int right = (y == n-1) ? 0 : backTrack(x, y+1, m, n, map);

        map.put(key, down+right); // store it in memorization map

        return map.get(key);

    }
}


