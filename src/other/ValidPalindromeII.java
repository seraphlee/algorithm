package other;

public class ValidPalindromeII {
    public static void main(String[] args) {
        System.out.println(validPalindrome("cbbcc"));
    }

    public static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() -1;

        while (start < end){
            if(s.charAt(start) != s.charAt(end))
                //越过存疑点，判断剩余字符串是否相等
               return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end -1);

            start++;
            end--;
        }

        return true;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
