package Q55JumpGame;
//55. Jump Game
//You are given an integer array nums. You are initially positioned at the array's first index,
// and each element in the array represents your maximum jump length at that position.
// Return true if you can reach the last index, or false otherwise.
//        Example 1:
//        Input: nums = [2,3,1,1,4]
//        Output: true
//        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

// Time complexity: O(N)
// Space complexity: O(1)
public class Solution {
    public static boolean canJump(int[] nums) {
        int maxPos = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > maxPos) return false;
            maxPos = Math.max(maxPos, i+nums[i]);
            if (maxPos >= nums.length-1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0}));
    }
}
