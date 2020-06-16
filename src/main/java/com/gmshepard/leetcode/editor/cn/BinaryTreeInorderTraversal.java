//Given a binary tree, return the inorder traversal of its nodes' values. 
//
// Example: 
//
// 
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,3,2] 
//
// Follow up: Recursive solution is trivial, could you do it iteratively? 
// Related Topics 栈 树 哈希表

  
package com.gmshepard.leetcode.editor.cn;

import com.gmshepard.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal{
public static void main(String[] args) {
    Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
    public List<Integer> inorderTraversal(TreeNode root) {
//        return stackTraversal(root);
        return anotherStackTraversal(root);
    }

    private List<Integer> stackTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null ) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    private List<Integer> anotherStackTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.add(root);
        while(!stack.empty()) {
            Object e = stack.pop();
            if (e == null) {
                continue;
            }

            if(e instanceof TreeNode) {
                stack.add(((TreeNode) e).right);
                stack.add(((TreeNode) e).val);
                stack.add(((TreeNode) e).left);
            } else if (e instanceof Integer) {
                result.add((Integer) e);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}