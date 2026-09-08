
package YalgoTraining.Season9.Block_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class A_diffNumbers_OK {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String line = reader.readLine().trim();
    String[] lineArr = line.split("\\s+");
    Set<String> set = new HashSet<>();
    for (String num: lineArr) {
      set.add(num);
    }

    writer.write(String.valueOf(set.size()));
    
    reader.close();
    writer.close();
  }
}
