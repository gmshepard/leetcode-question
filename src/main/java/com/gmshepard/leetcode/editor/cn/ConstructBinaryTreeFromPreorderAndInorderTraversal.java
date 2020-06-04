//Given preorder and inorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

  
package com.gmshepard.leetcode.editor.cn;

import com.gmshepard.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
public static void main(String[] args) {
    Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
    int[] preorder = {3,9,20,15,7};
    int[] inorder = {9,3,15,20,7};
    solution.buildTree(preorder, inorder);
}
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public Map<Integer, Integer> inValueIndexMap= new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length){
            throw new RuntimeException("invalid input params");
        }
        //建立中序遍历的值的索引
        for(int i=0; i< inorder.length; i++) {
            inValueIndexMap.put(inorder[i], i);
        }
        return buildTree(preorder,  0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int pIndex = inValueIndexMap.get(preorder[preStart]);
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = buildTree(preorder, preStart+1, pIndex+preStart-inStart, inorder, inStart, pIndex-1);
        root.right = buildTree(preorder, pIndex+preStart-inStart+1, preEnd, inorder, pIndex+1, inEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}