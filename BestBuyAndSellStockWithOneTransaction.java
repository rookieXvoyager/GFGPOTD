import java.util.*;
class BestBuyAndSellStockWithOneTransaction {
    public static int maxProfit(int[] prices) {
        // Code here
        // the idea is to track the minimum element in the array 
        if (prices.length<=1) return 0;
        int minMost =prices[0];
        int maxProfit =0;
        for (int i=1;i<prices.length;i++)
        {
            // find profit by subtracting the current price and update if greater than existing maxProfit
            maxProfit=Math.max(prices[i]-minMost, maxProfit);
            // updating minMost if a smaller value encoutered
            if (prices[i]<minMost)
            {
                minMost=prices[i];
            }
        }
        return maxProfit;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the stock prices seperated by spaces:");
        String [] inp=sc.nextLine().split(" ");
        int [] prices = new int[inp.length];
        for (int i=0;i<inp.length;i++)
        {
        prices[i]=Integer.parseInt(inp[i]);
        }

        System.out.println("The maximum profit that could be made out of a single transaction is:"+maxProfit(prices));
    }

}