public class Sqrtx {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }


    public static int mySqrt(int x) {
        int middle;
        int start = 0;
        int end = x;

        if(x == 1)
            return 1;

        while(start < end){
            middle = (start + end) / 2;

            if(middle > x/middle)
                end = middle;
            else if(middle < x/middle)
                start = middle;
            else
                return middle;

            if(x/middle > middle && x/(middle+1) < (middle+1))
                return middle;
        }

        return start;
    }

}
