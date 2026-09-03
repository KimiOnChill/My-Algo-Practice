package LeetCode;

public class n121BestTimeSell_OK {
    public static int maxProfit (int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int min = prices[0];
        int currentMax = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (currentMax < prices[i] - min) {
                currentMax = prices[i] - min;
            }
        }
        return currentMax;
    }

    public static void main(String[] args) {
        //int[] arr1 = {7,1,5,3,6,4}; // 5
        //int[] arr2 = {7,6,4,3,1}; // 0
        //int[] arr3 = {0,1}; // 1
        //int[] arr4 = {1,0}; // 0
        int[] arr5 = {7}; // 0
        int[] arr6 = {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7}; // 0
        //System.out.println(maxProfit(arr1));
        //System.out.println(maxProfit(arr2));
        //System.out.println(maxProfit(arr3));
        //System.out.println(maxProfit(arr4));
        System.out.println(maxProfit(arr5));
        System.out.println(maxProfit(arr6));
    }
}