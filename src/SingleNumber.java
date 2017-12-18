public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(singleNumber(nums));
    }

    //利用异或来做，相异为1，相同为0，0^x = x
    public static int singleNumber(int[] nums) {
        int a = 0;

        for (int i = 0; i < nums.length; i++) {
            a ^= nums[i];
        }

        return a;
    }
}
