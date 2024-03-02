package Q98ValidateBinarySearchTree;

// 98. Validate Binary Search Tree
// Given the root of a binary tree, determine if it is a valid binary search tree (BST).
// A valid BST is defined as follows:
//     The left subtree of a node contains only nodes with keys less than the node's key.
//     The right subtree of a node contains only nodes with keys greater than the node's key.
//     Both the left and right subtrees must also be binary search trees.

// Example:
// Input: root = [2,1,3]
// Output: true

// Time and space complexity 
// The time complexity of the isValidBST method is O(n), where n is the number of nodes in the binary tree. This is because we need to visit each node once to validate the binary search tree property.
// The space complexity of the isValidBST method is O(n), where n is the number of nodes in the binary tree. This is because we are using recursion to traverse the tree, and the maximum space required in the call stack is proportional to the height of the tree, which can be n in the worst case for an unbalanced tree.

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
    public boolean isValidBST(TreeNode root) {
        return traverse(root, null, null);
    }

    public boolean traverse(TreeNode root, Integer min_val, Integer max_val){
        if (root == null) return true;
        if ((min_val != null && root.val <= min_val) || (max_val != null && root.val >= max_val)) return false;
        return traverse(root.left, min_val, root.val) && traverse(root.right, root.val, max_val);
    }
}