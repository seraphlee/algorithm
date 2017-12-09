public class LengthofLastWord {
    public static void main(String[] args) {
        System.out.println();
    }

    public int lengthOfLastWord(String s) {
        if(s == null)
            return 0;

        String[] str = s.split(" ");

        if(str.length == 0)
            return 0;

        return str[str.length - 1].length();
    }
}
