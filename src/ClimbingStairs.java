public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    /**
     * 斐波那契数列
     * 时间复杂度为o(n)
     */
    public static int climbStairs(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;

        int one = 2;//前一个数
        int two = 1;//前两个数
        int all = 0;//目标数

        //从step = 3开始符合数列规律
        for (int i = 3; i <= n; i++) {
            all = one + two;
            two = one;
            one = all;
        }

        return all;
    }

}
