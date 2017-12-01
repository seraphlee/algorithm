/**
 * 普通方法循环处理会导致超时
 * 该方法初始化数组为O(n)，处理数组为O(1)
 */
public class NumArray {
    public static void main(String[] args){
        int[] example = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(example);

        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));

    }

    int[] nums;
    public NumArray(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }

        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if(i == 0)
            return nums[j];

        return nums[j] - nums[i-1];
    }
}