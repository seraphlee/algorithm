package other;

public class ImplementstrStr {
    public static void main(String[] args) {
        System.out.println(strStr("aaaa", "ab"));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
