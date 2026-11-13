public class BestSingleTradeProfit {

    static int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            int profit = prices[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] a = {7, 1, 5, 3, 6, 4};
        int[] b = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(a));
        System.out.println(maxProfit(b));
    }
}