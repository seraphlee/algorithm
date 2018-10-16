package utils;

public class Util {
    /**
     * 交换元素
     */
    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
