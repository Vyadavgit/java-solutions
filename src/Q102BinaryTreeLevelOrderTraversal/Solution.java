package Q102BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

// 102. Binary Tree Level Order Traversal
// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]

// Time complexity: O(n) where n is number of nodes
// Space complexity; O(n) where n is number of nodes

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        List<Integer> newList = new ArrayList<>();
        list.add(newList);
        traverse(root, list, 0);
        return list;
    }

    public void traverse(TreeNode root, List<List<Integer>> list, int level){
        if(root == null) return;
        if(level >= list.size()){
            List<Integer> newList = new ArrayList<>();
            newList.add(root.val);
            list.add(newList);
        } else {
            list.get(level).add(root.val);
        }
        traverse(root.left, list, level+1);
        traverse(root.right, list, level+1);
    }
}
