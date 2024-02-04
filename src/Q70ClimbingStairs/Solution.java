package Q70ClimbingStairs;

// 70. Climbing Stairs

// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Example 1:

// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps


// Time complexity: O(n)
// Space complexity: O(n)
public class Solution {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }


    public static int climbStairs(int n){
        int[] memo = new int[n+1]; // memorization array
        return paths(n, memo);
    }

    public static int paths(int n, int[] memo){ // no of paths for each number

        if(n <= 1) return 1; // base cond

        if(memo[n] != 0) return memo[n]; // if the memo exist for this num return the number of ways

        // total number of ways for each number n is sum of ways for (n-1) i.e. 1 step  and (n-2) i.e. 2 steps 
        memo[n] = paths(n-1, memo) + paths(n-2, memo); // memorize the number of ways for each n

        return memo[n];
        
    }
}
