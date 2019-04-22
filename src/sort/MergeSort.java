package sort;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int array[] = {9, 6, 7, 5, 3, 4, 2, 8, 0, 1};

        mergeSort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    /**
     * 归并排序
     */
    private static void mergeSort(int[] A, int p, int r) {
        if(p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p , q);
            mergeSort(A, q + 1 , r);
            merge(A, p, q, r);
        }
    }


    /**
     * 归并排序的中间态操作
     * @param A 待排序数组
     * @param p 左下标
     * @param q 中间某处下标
     * @param r 右下标
     *
     * 确保p <= q < r
     */
    private static void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1; //子数组1元素个数
        int n2 = r - q; //子数组2元素个数

        int[] L = new int[n1 + 1];//+1是为了加入哨兵牌
        int[] R = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = A[q + i + 1];
        }

        //哨兵牌
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i= 0;
        int j= 0;

        for (int k = p; k <= r; k++) {
            if(L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            }else {
                A[k] = R[j];
                j++;
            }
        }
    }
}
