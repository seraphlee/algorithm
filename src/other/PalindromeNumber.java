package other;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int rev = 0;

        //循环做到一半就够了
        while(x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        return x == rev || x == rev/10;
    }
}
