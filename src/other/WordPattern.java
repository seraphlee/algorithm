package other;

import java.util.HashMap;

public class WordPattern {
    static String pattern = "abba";
    static String str = "dog dog dog dog";

    public static void main(String[] args) {
        String[] strArray = str.split(" ");
        char[] patternArray = pattern.toCharArray();
        HashMap<Character, String> map = new HashMap<>();

        if (strArray.length != patternArray.length) {
            System.out.println("false");
            return;
        }

        for (int i = 0; i < strArray.length; i++) {
            if (map.containsKey(patternArray[i])) {
                String temp = map.get(patternArray[i]);
                if (!temp.equals(strArray[i])) {
                    System.out.println("false");
                    return;
                }
            } else if (map.containsValue(strArray[i])) {
                System.out.println("false");
                return;
            } else {
                map.put(patternArray[i], strArray[i]);
            }
        }
        System.out.println("true");

    }
}
