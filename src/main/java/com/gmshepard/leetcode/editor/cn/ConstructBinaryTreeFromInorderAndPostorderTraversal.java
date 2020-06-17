//Given inorder and postorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组

  
package com.gmshepard.leetcode.editor.cn;

import com.gmshepard.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal{
public static void main(String[] args) {
    Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length != inorder.length){
            throw new RuntimeException("invalid input params");
        }
        //建立中序遍历的值的索引
        for(int i=0; i< inorder.length; i++) {
            inValueIndexMap.put(inorder[i], i);
        }
        return buildTree(postorder,  0, postorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        if(postStart > postEnd || inStart > inEnd) {
            return null;
        }
        int pIndex = inValueIndexMap.get(postorder[postEnd]);
        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left = buildTree(postorder, postStart, pIndex-1+postStart-inStart, inorder, inStart, pIndex-1);
        root.right = buildTree(postorder, pIndex+postStart-inStart, postEnd-1, inorder, pIndex+1, inEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}