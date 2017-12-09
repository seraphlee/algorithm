public class RemoveElement {
    public static void main(String[] args) {
        int[] array = {3,3};

        System.out.println(removeElement(array, 3));
    }

    /**
     * 无聊的题目
     */
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
