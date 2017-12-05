public class TwoSumII {
    public static void main(String[] args) {
        int[] a = {-3, 3, 4, 90};

        for (int i = 0; i < 2; i++) {
            System.out.println(twoSum(a, 0)[i]);
        }

    }

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        int[] result = new int[2];

        while(start < end){
            if(numbers[end] > target && numbers[end] != 0 && numbers[start] > 0) {
                end--;
                continue;
            }

            if(numbers[start] + numbers[end] > target)
                end--;
            else if(numbers[start] + numbers[end] < target)
                start++;
            else{
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            }


        }

        return  result;
    }
}
