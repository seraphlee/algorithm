public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("abba","aabb"));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int[] array = new int[26];

        for (int i = 0; i < s.length(); i++) {
            array[sArray[i] - 'a'] += 1;
            array[tArray[i] - 'a'] -= 1;

        }

        for (int i = 0; i < 26; i++) {
            if(array[i] != 0)
                return false;
        }

        return true;

    }
}
