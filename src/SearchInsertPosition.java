public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};
        System.out.println(searchInsert(a, 2));
    }

    public static int searchInsert(int[] nums, int target) {
        if(target > nums[nums.length - 1])
            return nums.length;
        if(target < nums[0])
            return 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target)
                return i;
            else if((target > nums[i] && target < nums[i+1]) || i == nums.length -1 )
                return i + 1;

        }

        return 0;

    }

}
