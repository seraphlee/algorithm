/**
 * 简单的DP问题，状态转移方程dp[i] = A[i] + (dp[i-1] > 0? dp[i-1]:0)
 * 每个方程都包含A[i]是因为此题要求连续子序列，不能有断层
 * 可以用分治算法改进时间复杂度，还没想到办法
 */
public class MaximumSubarray {
    public static void main(String[] args){
        //int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {1};
        int max[] = new int[nums.length];
        int maxSum = nums[0];
        max[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max[i] = nums[i] + (max[i-1] > 0? max[i-1]:0);
            maxSum = maxSum > max[i]? maxSum: max[i];
        }

        System.out.println(maxSum);

    }
}
