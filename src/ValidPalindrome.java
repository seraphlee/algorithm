/**
 * 无聊的一道题
 */
public class ValidPalindrome {
    public static void main(String[] args){
        String str = "0P";

        if(str.isEmpty() || str.equals(" ") || str.length() == 1) {
            System.out.println("true");
            return;
        }
        char[] array = str.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if((array[i] >= '0' && array[i] <= '9')||(array[i] >= 'a' && array[i] <= 'z')){
                sb.append(array[i]);
            }
        }

        if(sb.toString().equals(sb.reverse().toString()))
            System.out.println("true");
        else
            System.out.println("false");

    }
}
