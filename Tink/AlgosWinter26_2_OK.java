import java.util.*;

class Solution {

  public int[] hoopsCalc(int n, int k, int[] hoopsArr){

    int[] resultArr = new int[n];
    resultArr[0] = 1;
    int lastScorred = hoopsArr[0];
    for(int i = 1; i < n; i++) {
      if (Math.abs(lastScorred - hoopsArr[i]) <= k) {
        lastScorred = hoopsArr[i];
        resultArr[i] = 1;
      }
      else {
        resultArr[i] = 0;
      }
    }
  return resultArr;
  }

  public static void main (String[] args) {

    Scanner scanner = new Scanner(System.in);

    String firstLine = scanner.nextLine().trim();
    String[] parts1 = firstLine.split("\\s+");
    int n = Integer.parseInt(parts1[0]);
    int k = Integer.parseInt(parts1[1]);

    int[] hoopsArr = new int[n];
    String secondLine = scanner.nextLine().trim();
    String[] hoops = secondLine.split("\\s+");
    for (int i = 0; i < n; i++){
      hoopsArr[i] = Integer.parseInt(hoops[i]);
    }
    scanner.close();

    Solution solutionRun = new Solution();
    int[] test1 = solutionRun.hoopsCalc(n, k, hoopsArr);
    System.out.println("Test 1: " + Arrays.toString(test1));
    // System.out.println(n + " " + k + " " + Arrays.toString(hoopsArr));
  }
}