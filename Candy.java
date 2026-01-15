import java.util.*;

class Candy {
    public static int minCandy(int arr[]) {
        // code here
        if (arr.length == 0)
            return 0;
        int[] candies = new int[arr.length];
        Arrays.fill(candies, 1);
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1 && (arr[i] < arr[i + 1] && candies[i] >= candies[i + 1])) {
                candies[i + 1] = candies[i] + 1;
                System.out.println("candies " + i + "+1 has been updated to" + candies[i + 1]);
            }
            if (i > 0 && (arr[i] < arr[i - 1] && candies[i] >= candies[i - 1])) {
                candies[i - 1] = candies[i] + 1;
                System.out.println("candies " + i + "-1 has been updated to" + candies[i - 1]);

            }
        }
        for (int i = arr.length-1; i >=0; i--) {
            if (i < arr.length - 1 && (arr[i] < arr[i + 1] && candies[i] >= candies[i + 1])) {
                candies[i + 1] = candies[i] + 1;
                System.out.println("candies " + i + "+1 has been updated to" + candies[i + 1]);
            }
            if (i > 0 && (arr[i] < arr[i - 1] && candies[i] >= candies[i - 1])) {
                candies[i - 1] = candies[i] + 1;
                System.out.println("candies " + i + "-1 has been updated to" + candies[i - 1]);

            }
        }
        int count = 0;
        for (int el : candies)
            count += el;
        return count;
    }

    public static void main(String[] args)

    {
        Scanner sc = new Scanner(System.in);
        String[] inp = sc.nextLine().split(" ");
        int[] arr = new int[inp.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }
        System.out.println(minCandy(arr));

    }

}