package other;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] array = {"a"};
        System.out.println(longestCommonPrefix(array));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs[0].equals(""))
            return "";

        int minLength = strs[0].length();
        String minStr = "";
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].length() <= minLength) {
                minLength = strs[i].length();
                minStr = strs[i];
            }
        }

        if(minLength == 0)
            return "";

        for (int i = 0; i < minLength; i++) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) != temp)
                    return strs[0].substring(0, i);
            }
        }

        return minStr;

    }
}
