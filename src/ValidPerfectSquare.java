/**
 * 采用二分法
 * 1.注意中间值的选取，应为段落的中间值，即start + (end - start) / 2
 * 2.注意middle的比较，整数除法会取整
 *
 */
public class ValidPerfectSquare {
    public static void main(String[] args){
        int num = 5;

        int start = 1;
        int middle;
        int end = num;

        if(num <= 0)
            System.out.println("false");
        if(num == 1)
            System.out.println("true");

        while(end >= start){
            middle = start + (end - start) / 2;
            if(middle == (float)num / middle){
                System.out.println("true");
                return;
            }else if(middle > num / middle) {
                end = middle - 1;
            }else {
                start = middle + 1;
            }
        }

        System.out.println("false");

    }
}
