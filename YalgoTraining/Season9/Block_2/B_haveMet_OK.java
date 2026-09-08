package YalgoTraining.Season9.Block_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class B_haveMet_OK {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String line = reader.readLine().trim();
    String[] lineArr = line.split("\\s+");
    HashMap<String, String> map = new HashMap<>();
    for (String num: lineArr) {
      if (map.containsKey(num)) {
        writer.write("YES");
        writer.newLine();
      } else{
        writer.write("NO");
        writer.newLine();
        map.put(num, "OK");
      }
    }
    
    reader.close();
    writer.close();
  }
}
