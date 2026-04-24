package YalgoTraining.Block_2.Competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C6_A {

  public static int[] qiuckSortFunction(int[] inputArr) {

    if (inputArr.length <= 1) {
      return inputArr;
    }
    int pivot = inputArr[0];
    ArrayList<Integer> leftArr = new ArrayList<Integer>();
    ArrayList<Integer> rightArr = new ArrayList<Integer>();

    for (int i = 1; i < inputArr.length; i++) {
      if (inputArr[i] > pivot) {
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

    String line = reader.readLine().trim();
    String[] lineArr = line.split("");

    Stream<Integer> stream = Arrays.stream(lineArr).map(Integer::parseInt);
    int[] arrOfNums = stream.mapToInt(Integer::intValue).toArray();

    int[] sortedArr = qiuckSortFunction(arrOfNums);

    if(sortedArr[0] == 0){
      String res ="";
      for (int x : sortedArr){
        res += x;
      }
      writer.write(res);
      reader.close();
      writer.close();
      return;
    }

    String combined = Arrays.stream(sortedArr).mapToObj(String::valueOf).collect(Collectors.joining());
    long result = Long.parseLong(combined);

    if (result % 3 !=0){
      int[] withoutLast = new int[sortedArr.length - 1];
      System.arraycopy(sortedArr, 0, withoutLast, 0, sortedArr.length - 1);
      combined = Arrays.stream(withoutLast).mapToObj(String::valueOf).collect(Collectors.joining());
      result = Long.parseLong(combined);
    }

    writer.write(String.valueOf(result));

    reader.close();
    writer.close();
  }
}