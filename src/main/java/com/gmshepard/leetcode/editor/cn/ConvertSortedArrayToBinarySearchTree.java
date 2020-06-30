//Given an array where elements are sorted in ascending order, convert it to a h
//eight balanced BST. 
//
// For this problem, a height-balanced binary tree is defined as a binary tree i
//n which the depth of the two subtrees of every node never differ by more than 1.
// 
//
// Example: 
//
// 
//Given the sorted array: [-10,-3,0,5,9],
//
//One possible answer is: [0,-3,9,-10,null,5], which represents the following he
//ight balanced BST:
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索


package com.gmshepard.leetcode.editor.cn;

import com.gmshepard.leetcode.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
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
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums.length == 0) {
                return null;
            }
            return constructTree(0, nums.length, nums);
        }

        private TreeNode constructTree(int start, int end, int[] nums) {
            if (start == end) {
                return null;
            }
            int rootIndex = (start + end) >>> 1;
            TreeNode root = new TreeNode(nums[rootIndex]);
            root.left = constructTree(start, rootIndex, nums);
            root.right = constructTree(rootIndex + 1, end, nums);
            return root;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}