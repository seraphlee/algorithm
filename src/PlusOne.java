public class PlusOne {
    public static void main(String[] args) {
        int[] a = {9,9,9};

        int[] b = plusOne(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(b[i]);
        }

    }

    public static int[] plusOne(int[] digits) {
        boolean flag = false;

        digits[digits.length - 1] += 1;

        if(digits[digits.length - 1] == 10) {
            flag = true;
            digits[digits.length - 1] = 0 ;
        }else{
            return digits;
        }

        for (int i = 1; i < digits.length; i++) {

            if(flag)
                digits[digits.length - i - 1] += 1;

            if(digits[digits.length - i - 1] == 10) {
                flag = true;
                digits[digits.length - i - 1] = 0;
            }else
                flag = false;
        }

        if(digits[0] == 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }


        return digits;
    }
}
