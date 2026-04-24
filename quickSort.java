import java.util.*;

public class quickSort {

  public static int[] qiuckSortFunction (int[] inputArr) {

    if (inputArr.length <= 1) {return inputArr;}
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
    System.arraycopy(rightRes, 0, result, leftRes.length+1, rightRes.length);

    return result;
  }

  public static void main (String[] args) {
    // int[] arr = {1, 2, 4, 7, 1, 3, 9, 6, 5, 11};
    int[] arr = {4,3,2,1};
    System.out.println(Arrays.toString(qiuckSortFunction(arr)));
  }
}