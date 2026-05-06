package YalgoTraining.Block_1.Competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.AbstractList;
import java.util.List;

public class C1_2 {
  public class ZeroesList extends AbstractList<Integer> {
    private final long size; // 10^9 fits in long

    public ZeroesList(long size) {
      if (size > Integer.MAX_VALUE)
        throw new IllegalArgumentException("Too large");
      this.size = size;
    }

    @Override
    public Integer get(int index) {
      if (index < 0 || index >= size)
        throw new IndexOutOfBoundsException();
      return 0;
    }

    @Override
    public int size() {
      return (int) size;
    }
  }
  //Usage: List<Integer> zeroes = new ZeroesList(1000000000L); int zero = zeroes.get(500000000);

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    /*
     * Пример ввода и вывода числа n, где -10^9 < n < 10^9:
     * int n = Integer.parseInt(reader.readLine());
     * writer.write(String.valueOf(n));
     */

    reader.close();
    writer.close();
  }
}
