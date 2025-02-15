package leetcode;

/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    private int rob(int i, int[] nums, int[] dp) {
        if(i<0) return 0;
        if(i==0) {
            return nums[i];
        }
        if(dp[i] != -1) return dp[i];
        int pick = nums[i] + rob(i-2, nums, dp);    
        int notPick = rob(i-1, nums, dp);
        return dp[i] = Math.max(pick, notPick);
    }

    public int rob(int[] nums) {
        int size = nums.length;
        if(size == 1) return nums[0];
        int[] dp = new int[size];
        Arrays.fill(dp, -1);
        int withFirst = rob(size-2, Arrays.copyOf(nums, size-1), dp);
        Arrays.fill(dp, -1);
        int withoutFirst = rob(size-2, Arrays.copyOfRange(nums, 1, size), dp);

        return Math.max(withFirst, withoutFirst);
    }
}
// @lc code=end

public class LC213 {
    public static void main(String[] args) {
        int[] nums = new int[] {200,3,140,20,10};
        Solution solution = new Solution();
        System.out.println(solution.rob(nums));
    }
}

