package LeetCode;

import java.util.HashMap;

public class stockMarket1 {
    
  public static int findMostProfit(int[] input) {
    HashMap <String, Integer> minimum = new HashMap<>();
    HashMap <String, Integer> maximum = new HashMap<>();

    minimum.put("position", 0);
    minimum.put("value", input[0]);

    maximum.put("position", -1);
    maximum.put("value", 1);

    for (int i = 0 ; i <= input.length-1; i++) {
        if (input[i] < minimum.get("value")) {
            minimum.put("value", input[i]);
            minimum.put("position", i);
        } else if (input[i] > minimum.get("value") && input[i] >=    maximum.get("value") && i > minimum.get ("position")) {
            maximum.put("position", i);
            maximum.put("value", input[i]);
        }
    }
    System.out.println(minimum);
    System.out.println(maximum);

    if (maximum.get("position") == -1) {
        return 0;
    } else {
        return maximum.get("value") - minimum.get("value");
    }
  }

  public static void main(String[] args) {
    // int[] arr1 = {7,1,5,3,6,4}; // 5
    int[] arr2 = {7,6,4,3,1}; // 0
    int[] arr3 = {0,1}; // 1
    // int[] arr4 = {1,0}; // 0
    // int[] arr5 = {7}; // 0
    // int[] arr6 = {7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7}; // 0
    // System.out.println(findMostProfit(arr1));
    System.out.println(findMostProfit(arr2));
    System.out.println(findMostProfit(arr3));
    // System.out.println(findMostProfit(arr4));
    // System.out.println(findMostProfit(arr5));
    // System.out.println(findMostProfit(arr6));
  }
}
