//Given a binary tree, find its maximum depth. 
//
// The maximum depth is the number of nodes along the longest path from the root
// node down to the farthest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given binary tree [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// return its depth = 3. 
// Related Topics 树 深度优先搜索


package com.gmshepard.leetcode.editor.cn;

import com.gmshepard.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
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
        public int maxDepth(TreeNode root) {
//        return recursion(root);
            return bfs(root);
        }

//    private int recursion(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return 1 + Math.max(recursion(root.left), recursion(root.right));
//    }

        private int bfs(TreeNode root) {
            Queue<TreeNode> levelNodes = new LinkedList<>();
            if (root == null) {
                return 0;
            }
            levelNodes.offer(root);
            int level = 0;
            while (!levelNodes.isEmpty()) {
                int currentLevelNodeNums = levelNodes.size();
                for (int i = 0; i < currentLevelNodeNums; i++) {
                    TreeNode node = levelNodes.poll();
                    if (node != null) {
                        if (node.left != null) {
                            levelNodes.offer(node.left);
                        }

                        if (node.right != null) {
                            levelNodes.offer(node.right);
                        }
                    }
                }
                level++;
            }
            return level;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}