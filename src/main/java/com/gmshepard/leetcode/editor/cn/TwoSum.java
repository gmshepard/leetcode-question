//Given an array of integers, return indices of the two numbers such that they a
//dd up to a specific target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// Example: 
//
// 
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
// 
// Related Topics 数组 哈希表


package com.gmshepard.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> sumPair = new HashMap<>();
            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {
                int t = target - nums[i];
                if (sumPair.containsKey(t)) {
                    result[0] = i;
                    result[1] = sumPair.get(t);
                    return result;
                } else {
                    sumPair.put(nums[i], i);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}