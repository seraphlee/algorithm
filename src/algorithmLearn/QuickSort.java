package algorithmLearn;

import utils.Util;

public class QuickSort {
    public static void main(String[] args) {
        int array[] = {9, 6, 7, 5, 3, 4, 2, 8, 0, 1};

        quickSort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    /**
     * 快速排序
     * @param A 输入数组
     * @param p 左下标
     * @param r 右下标
     */
    private static void quickSort(int[] A, int p, int r) {
        if(p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    /**
     * 对子数组进行原址重排
     *
     * 两个游标i j, i用于指代比主元小的数，j用于遍历子数组
     *
     */
    private static int partition(int[] A, int p, int r) {
        int x = A[r];//主元
        int i = p - 1;

        for (int j = p; j <= r - 1; j++) {
            if(A[j] <= x) {
                i++;
                Util.swap(A, i, j);
            }
        }

        Util.swap(A, i + 1, r);

        return i + 1;
    }
}
