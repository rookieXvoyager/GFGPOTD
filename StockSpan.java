import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;
public class StockSpan {
  public static ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        // the idea is to use a monotonic decreasing stack to determine th previous greater el
        // anything after the pge will be included as a consecutive day till the current date
        ArrayList<Integer> spans = new ArrayList<>();
        //  A monotonic increasing stack to maintain the index of the pge
        Stack <Integer> stack = new Stack<>();
        for ( int idx =0;idx<arr.length;idx++)
        {
                    //remove until there are no elements lesser than or equal to curent stock price 
            while (!stack.isEmpty() &&arr[stack.peek()]<=arr[idx])
            {
                stack.pop();
                
            }
            // calculate the span
            int span=idx-(stack.isEmpty()?-1:stack.peek());
            spans.add(span);
            // add the current index as the largest stock price 
            stack.push(idx);
        }
       
        
        return spans;
    }  
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the stock prices seperated by space:");
        String [] inp = sc.nextLine().split(" ");
        int [] prices = new int [inp.length];
        for ( int i=0;i<inp.length;i++)
        {
            prices[i]=Integer.parseInt(inp[i]);
        }
        System.out.println("The span of each stock price is"+calculateSpan(prices));
    }
}
