//Given a binary tree, return the bottom-up level order traversal of its nodes' 
//values. (ie, from left to right, level by level from leaf to root). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its bottom-up level order traversal as: 
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索


package com.gmshepard.leetcode.editor.cn;

import com.gmshepard.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            return bfs(root);
        }

        private List<List<Integer>> bfs(TreeNode root) {
            Queue<TreeNode> levelNodes = new LinkedList<>();
            List<List<Integer>> ans = new LinkedList<>();
            if (root == null) {
                return ans;
            }
            levelNodes.offer(root);
            while (!levelNodes.isEmpty()) {
                int currentLevelNodeNums = levelNodes.size();
                List<Integer> currentLevelNodeValue = new ArrayList<>();
                for (int i = 0; i < currentLevelNodeNums; i++) {
                    TreeNode node = levelNodes.poll();
                    if (node != null) {
                        currentLevelNodeValue.add(node.val);
                        levelNodes.offer(node.left);
                        levelNodes.offer(node.right);
                    }
                }
                if (currentLevelNodeValue.size() != 0) {
                    ans.add(0, currentLevelNodeValue);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}