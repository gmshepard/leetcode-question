//Given a non-empty binary tree, find the maximum path sum. 
//
// For this problem, a path is defined as any sequence of nodes from some starti
//ng node to any node in the tree along the parent-child connections. The path mus
//t contain at least one node and does not need to go through the root. 
//
// Example 1: 
//
// 
//Input: [1,2,3]
//
//       1
//      / \
//     2   3
//
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//Output: 42
// 
// Related Topics 树 深度优先搜索


package com.gmshepard.leetcode.editor.cn;


import com.gmshepard.leetcode.TreeNode;

public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int ans = Integer.MIN_VALUE;

        public int onSideMax(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left = Math.max(0, onSideMax(node.left));
            int right = Math.max(0, onSideMax(node.right));
            ans = Math.max(ans, left + right + node.val);
            return Math.max(left, right) + node.val;
        }

        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            onSideMax(root);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}