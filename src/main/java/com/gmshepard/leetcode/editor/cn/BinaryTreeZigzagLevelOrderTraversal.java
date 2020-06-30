//Given a binary tree, return the zigzag level order traversal of its nodes' val
//ues. (ie, from left to right, then right to left for the next level and alternat
//e between). 
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
//return its zigzag level order traversal as: 
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索


package com.gmshepard.leetcode.editor.cn;

import com.gmshepard.leetcode.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            return bfs(root);
        }

        private List<List<Integer>> bfs(TreeNode root) {
            Queue<TreeNode> levelNodes = new LinkedList<>();
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            levelNodes.offer(root);
            int level = 0;
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
                    if (level % 2 != 0) {
                        Collections.reverse(currentLevelNodeValue);
                    }
                    ans.add(currentLevelNodeValue);
                    level++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}