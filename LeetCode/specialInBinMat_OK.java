package LeetCode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class specialInBinMat_OK {

  public static int numSpecial(int[][] mat) {

    ArrayList<Integer> rowsSum = new ArrayList<Integer>();
    for (int[] row : mat) {
      IntStream streamRow = Arrays.stream(row);
      OptionalInt sum = streamRow.reduce((a, b) -> a + b);
      rowsSum.add(sum.orElse(0));
    }
    System.out.println("Array of row sums:" + Arrays.toString(rowsSum.toArray()));

    int result = IntStream.range(0, rowsSum.size())
        .filter(i -> rowsSum.get(i) == 1)
        .map(i -> {
          int oneIndex = IntStream.range(0, mat[i].length)
              .filter(j -> mat[i][j] == 1)
              .findFirst()
              .orElse(-1);
          if (oneIndex == -1)
            return 0;

          List<Integer> col = IntStream.range(0, mat.length)
              .mapToObj(k -> mat[k][oneIndex])
              .collect(Collectors.toList());
          return col.stream().reduce(0, Integer::sum) == 1 ? 1 : 0;
        })
        .sum();
    return result;
  }

  public static void main(String[] args) {
    int[][] mat1 = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
    int[][] mat2 = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
    int[][] mat3 = { { 0, 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 1 }, { 0, 0, 0, 0, 1, 0, 0, 0 },
        { 1, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 1, 1, 0, 0, 0, 0 } };
    System.out.println(numSpecial(mat1));
    System.out.println(numSpecial(mat2));
    System.out.println(numSpecial(mat3));
  }
}
