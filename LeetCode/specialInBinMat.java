package LeetCode;
import java.util.*;
import java.util.stream.IntStream;

public class specialInBinMat {

  public static int numSpecial(int[][] mat) {
    int result = 0;
    ArrayList<OptionalInt> rowsSum = new ArrayList<OptionalInt>();
    //todo: create loop for this int[] columnsSum = new int[mat[0].length];
    for (int[] row: mat ) {
      IntStream stream = Arrays.stream(row);
      OptionalInt sum = stream.reduce((a,b) -> a+b);
      rowsSum.add(sum); //todo: convert OptionalInt
    } 
    return result;
  }

  public static void main (String[] args) {
    int[][] mat1 = {{1,0,0},{0,0,1},{1,0,0}};
    //int[][] mat2 = {{1,0,0},{0,1,0},{0,0,1}};
    System.out.println(numSpecial(mat1));
    //System.out.println(numSpecial(mat2));
  }
}
