package RandomSources;
import java.util.*;

//Написана функцию findUnique, которая вернет все уникальные числа за один проход (без использования Set).
// expected [ 2, 5 ]
// time: O(n)
// space: O(n)
// ! done

public class interviewTest_1_OK {

  public static String findUnique(int[] args) {
    HashMap<Integer, Integer> numPairs = new HashMap<Integer, Integer>();
    ArrayList<Integer> resultArr = new ArrayList<Integer>();

    for (int i : args){
      if (numPairs.containsKey(i)) {
        int pastValue = numPairs.get(i);
        numPairs.put(i, pastValue+1);
      }
      else {
        numPairs.put(i, 1);
      }
    }
    System.out.println("map: " + numPairs);

    for (int j: numPairs.keySet()){
      int value = numPairs.get(j);
      if (value == 1) {
        resultArr.add(j);
      }
    }
  
    return Arrays.toString(resultArr.toArray());
  }
    
  public static void main(String[] args) {
    int[] notUniqueNumbers = { 1, 2, 5, 7, 7, 11, 12, 11, 1, 12 };
    System.out.println(findUnique(notUniqueNumbers)); 
  }
}
