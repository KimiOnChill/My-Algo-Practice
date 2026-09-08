package YalgoTraining.Season9.Block_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class C_intersections_OK {
  public static int[] qiuckSortFunction(int[] inputArr) {

    if (inputArr.length <= 1) {
      return inputArr;
    }
    int pivot = inputArr[0];
    ArrayList<Integer> leftArr = new ArrayList<Integer>();
    ArrayList<Integer> rightArr = new ArrayList<Integer>();

    for (int i = 1; i < inputArr.length; i++) {
      if (inputArr[i] < pivot) {
        leftArr.add(inputArr[i]);
      } else {
        rightArr.add(inputArr[i]);
      }
    }

    int[] leftFurther = leftArr.stream().mapToInt(Integer::intValue).toArray();
    int[] rightFurther = rightArr.stream().mapToInt(Integer::intValue).toArray();

    int[] leftRes = qiuckSortFunction(leftFurther);
    int[] rightRes = qiuckSortFunction(rightFurther);

    int[] result = new int[leftRes.length + rightRes.length + 1];
    System.arraycopy(leftRes, 0, result, 0, leftRes.length);
    System.arraycopy(inputArr, 0, result, leftRes.length, 1);
    System.arraycopy(rightRes, 0, result, leftRes.length + 1, rightRes.length);

    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String firstLine = reader.readLine().trim();
    String[] firstLineArr = firstLine.split("\\s+");
    HashMap<Integer, Boolean> map = new HashMap<>();
    for (String num : firstLineArr) {
      map.put(Integer.parseInt(num), true);
    }

    ArrayList<Integer> result = new ArrayList<>();
    String secondLine = reader.readLine().trim();
    String[] secondLineArr = secondLine.split("\\s+");
    for (String num : secondLineArr) {
      Integer n = Integer.parseInt(num);
      if (map.containsKey(n)) {
        result.add(n);
      }
    }

    int[] intersections = new int[result.size()];
    for (int i = 0; i < intersections.length; i++) {
      intersections[i] = result.get(i);
    }

    int[] arr = qiuckSortFunction(intersections);
    StringBuilder res = new StringBuilder();
    for (int num : arr) {
      res.append(num + " ");
    }

    writer.write(res.toString().trim());

    reader.close();
    writer.close();
  }
}
