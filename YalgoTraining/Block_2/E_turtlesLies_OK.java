package YalgoTraining.Block_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class E_turtlesLies_OK {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(reader.readLine().trim());
    int result = 0;
    HashMap<String, Boolean> truth = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String line = reader.readLine();
      String[] lineArr = line.split("\\s+");
      int first = Integer.parseInt(lineArr[0]);
      int second = Integer.parseInt(lineArr[1]);
      if (first >= 0 && second >= 0 && first + second == n-1 && !truth.containsKey(line)) {
        truth.put(line, true);
        result++;
      }
    }

    writer.write(String.valueOf(result));
    reader.close();
    writer.close();
  }
}
