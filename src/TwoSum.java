/**
 * 这个方法时间复杂度太高，感觉可以用动态规划来优化，等我学了后再来改逻辑
 */
public class TwoSum {


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] array = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target && (i != j)) {
                    array[0] = i;
                    array[1] = j;

                }
            }
        }

        //return array;
    }

}
