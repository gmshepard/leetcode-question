//Given a binary tree, return the level order traversal of its nodes' values. (i
//e, from left to right, level by level). 
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
//return its level order traversal as: 
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


package com.gmshepard.leetcode.editor.cn;

import com.gmshepard.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(root, 0, ans);
            return ans;
//        return bfs(root);
        }

        private List<List<Integer>> bfs(TreeNode root) {
            Queue<TreeNode> levelNodes = new LinkedList<>();
            List<List<Integer>> ans = new ArrayList<>();
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
                    ans.add(currentLevelNodeValue);
                }
            }
            return ans;
        }

        private void dfs(TreeNode node, int level, List<List<Integer>> ans) {
            if (node == null) {
                return;
            }
            if (ans.size() <= level) {
                ans.add(new ArrayList<>());
            }

            ans.get(level).add(node.val);
            dfs(node.left, level + 1, ans);
            dfs(node.right, level + 1, ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}