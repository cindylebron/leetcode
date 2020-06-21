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
    // DFS recursion
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return getSum(root, sum, 0);
    }
    public boolean getSum(TreeNode root, int target, int curSum) {
        if (root == null) return false;
        
        curSum += root.val;
        if (root.left == null && root.right == null) {
            return target == curSum;
        }
        
        if (getSum(root.left, target, curSum)) return true;
        if (getSum(root.right, target, curSum)) return true;
        
        return false;
    }
}