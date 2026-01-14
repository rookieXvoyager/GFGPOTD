import java.util.*;

class PoliceAndThieves {
    // code here
    // the idea is to use a two - pointer approach
    // one pointer to track the corresponding police
    // other to track the correspoding thief
    public static int catchThieves(char[] arr, int k) {

        // declaring the initial pointers
        int police = 0, thief = 0, count = 0;
        // determining the initial poisitions
        int N = arr.length;
        while (police < N && arr[police] != 'P')
            police++;
        while (thief < N && arr[thief] != 'T')
            thief++;

        // increase the count if the thief is in the police's range
        while (police < N && thief < N) {
            // if in the range
            if (Math.abs(police - thief) <= k) {
                // System.out.println("Police at"+police+" and thief at "+thief);
                count++;
                police++;
                thief++;
            } else if (police < N && police < thief) {
                // if the police remains behind
                police++;
            } else if (thief < N && thief < police) {
                // if the thief remains behind
                thief++;
            }
            // move to the next police or thief
            while (police < N && arr[police] != 'P')
                police++;
            while (thief < N && arr[thief] != 'T')
                thief++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input char array seperated by space: ");
        String[] inp = sc.nextLine().split(" ");
        char[] chars = new char[inp.length];
        for (int i = 0; i < inp.length; i++) {
            chars[i] = inp[i].charAt(0);
        }
        System.out.println("Enter the value of K:");
        int k = sc.nextInt();
        System.out.println("The maximum count of thieves that can be caught are" + catchThieves(chars, k));
    }
}