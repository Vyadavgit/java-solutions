package Q104MaximumDepthofBinaryTree;

// 104. Maximum Depth of Binary Tree
// Given the root of a binary tree, return its maximum depth.
// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

// Time complexity: O(n) where n is number of nodes
// Space complexity: O(h) where h is height of tree 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        int left_depth, right_depth;
        if(root == null) return 0;
        else{
            left_depth = maxDepth(root.left);
            right_depth = maxDepth(root.right);
        }
        return Math.max(left_depth, right_depth)+1;
    }
}