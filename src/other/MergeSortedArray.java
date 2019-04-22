package other;

public class MergeSortedArray {
    public static void main(String[] args) {
        System.out.println();
    }

    //题目中假定nums1的长度大于或等于m+n, nums1的有效位数为m, nums2为n
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k = m+n-1;
        while(i >=0 && j>=0)
        {
            if(nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        while(j>=0)
            nums1[k--] = nums2[j--];
    }
}
