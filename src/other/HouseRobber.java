package other;

/**
 * 抢或者不抢这是个问题
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,3,1,3,100};
        int[][] max = new int[nums.length][2];

        max[0][0] = 0;
        max[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max[i][0] = Math.max(max[i-1][1], max[i-1][0]);
            max[i][1] = max[i-1][0] + nums[i];
        }

        System.out.println(Math.max(max[nums.length-1][0], max[nums.length-1][1]));
    }
}
