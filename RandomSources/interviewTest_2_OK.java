package RandomSources;
import java.util.*;

//Дан массив чисел от 1 до N в произвольном порядке, одно число пропущено. 
//Нужно определить пропущенное число. Значение N заранее неизвестно.

// [2, 1, 3, 5] -> 4
// expected 4
// time: 
// space: 

public class interviewTest_2_OK {

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

  public static int findMissing(int[] args) {
    int[] sortedArr = qiuckSortFunction(args);
    int result = 0;
    for (int i = 1; i < sortedArr.length; i++) {
      if (sortedArr[i] - sortedArr[i-1] != 1) {return result = sortedArr[i] - 1;}
    }
    return result;
  }
    
  public static void main(String[] args) {
    int[] arr = { 2, 1, 3, 5 };
    System.out.println(findMissing(arr)); 
  }
}

