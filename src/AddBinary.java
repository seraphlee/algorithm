public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("111", "1"));
    }

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0){
            int sum = ((i < 0) ? 0 : (a.charAt(i--) - '0')) +
                    ((j < 0) ? 0 : (b.charAt(j--) - '0')) +
                    carry;

            sb.append(Integer.toString(sum & 1));
            carry = (sum >> 1) & 1;
        }

        return sb.reverse().toString();
    }


}
