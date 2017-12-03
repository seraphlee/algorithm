public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] array = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(array));
    }


    public static int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        if(prices.length == 1)
            return 0;

        int dp[] = new int[prices.length];
        dp[0] = 0;//哪天卖
        int min = prices[0];//最小买入值
        int max = 0;//最大利润

        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(dp[i-1], prices[i] - min);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
