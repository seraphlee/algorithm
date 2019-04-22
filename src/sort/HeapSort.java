package sort;


/**
 * 堆排序
 */
public class HeapSort {
    static int heapSize;

    public static void main(String[] args) {
        int array[] = {9, 6, 7, 5, 3, 4, 2, 8, 0, 1};

        heapSize = array.length;

        heapSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    /**
     * 堆排序
     * @param A 输入数组
     */
    private static void heapSort(int[] A) {
        buildMaxHeap(A);

        for (int i = A.length - 1; i > 0; i--) {
            int tmp = A[0];
            A[0] = A[i];
            A[i] = tmp;

            heapSize -= 1;

            maxHeapify(A, 0);
        }
    }

    /**
     * 建堆
     * 把数组转换为最大堆
     * @param A 输入数组
     */
    private static void buildMaxHeap(int[] A) {
        //从倒数第二层开始循环，逐步向上
        for (int i = (A.length - 1) / 2; i >= 0; i--) {
            maxHeapify(A, i);
        }
    }

    /**
     * 维护堆的性质
     * 使得以下标i为根结点的子树重新遵循最大堆的性质
     * @param A 输入数组
     * @param i 下标
     */
    private static void maxHeapify(int[] A, int i) {
        int largest; //存储最大点的下标
        int l = 2 * i;
        int r = 2 * i + 1;

        if(l <= heapSize - 1 && A[l] > A[i]) {
            largest = l;
        }else {
            largest = i;
        }

        if(r <= heapSize - 1 && A[r] > A[largest]) {
            largest = r;
        }

        if(largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;

            maxHeapify(A, largest);
        }
    }

    /**
     * 最大优先队列
     * maximum操作
     *
     * @param A 已经是最大堆结构的输入数组
     * @return 最大值
     */
    private int maximum(int[] A) {
        return A[0];
    }

    /**
     * 最大优先队列
     * extractMax操作
     *
     * @param A 已经是最大堆结构的输入数组
     * @return 最大值
     */
    private int extractMax(int[] A) {
        try {
            if (heapSize < 0) {
                throw new Exception();
            }
        }catch (Exception e) {
            System.out.print("堆溢出");
        }

        int max = A[0];
        A[0] = A[heapSize - 1];
        heapSize -= 1;
        maxHeapify(A, 0);

        return max;
    }

    /**
     * 最大优先队列
     * increaseKey操作
     *
     * @param A 已经是最大堆结构的输入数组
     * @param i 下标
     * @param key 希望增大到的值
     */
    private void increaseKey(int[] A, int i, int key) {
        if(key < A[i]) {
            return;
        }

        A[i] = key;

        while (i > 0 && A[i/2] < A[i]) {
            int tmp = A[i];
            A[i] = A[i/2];
            A[i/2] = tmp;

            i = i/2;
        }
    }

    /**
     * 最大优先队列
     * insert操作
     *
     * @param A 已经是最大堆结构的输入数组
     * @param key 希望插入的关键字
     */
    private void insert(int[] A, int key) {
        int[] B = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i];
        }

        B[A.length] = Integer.MIN_VALUE;

        increaseKey(B, A.length, key);
    }
}
