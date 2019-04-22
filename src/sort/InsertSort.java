package sort;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int array[] = {9, 6, 7, 5, 3, 4, 2, 8, 0, 1};

        for (int i = 1; i < array.length; i++) {
            int key = array[i]; //将被排序的值
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1 ;
            }

            array[j + 1] = key;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
