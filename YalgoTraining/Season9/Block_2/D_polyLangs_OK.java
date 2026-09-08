
package YalgoTraining.Season9.Block_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Stream;

public class D_polyLangs_OK {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(reader.readLine());
    HashMap<String, Integer> intersectLangs = new HashMap<>();
    HashSet<String> allLangs = new HashSet<>();

    for (int j = 0; j < n; j++) {
      int m = Integer.parseInt(reader.readLine());
      for (int i = 0; i < m; i++) {
        String lang = reader.readLine();
        allLangs.add(lang);
        if (intersectLangs.containsKey(lang)) {
          int prevNum = intersectLangs.get(lang);
          intersectLangs.put(lang, prevNum + 1);
        } else {
          intersectLangs.put(lang, 1);
        }
      }
    }

    // System.out.println(intersectLangs);
    // System.out.println(allLangs);
    ArrayList<String> intersectArr = new ArrayList<>();
    intersectLangs.entrySet()
        .stream()
        .forEach(e -> {
          if (e.getValue() == n) {
            intersectArr.add(e.getKey());
          }
        });

    writer.write(String.valueOf(intersectArr.size()));
    Stream<String> stream = intersectArr.stream();
    stream.forEach(e -> {
      try {
        writer.newLine();
        writer.write(e);
      } catch (IOException e1) {
        e1.printStackTrace();
      }
      });
    writer.newLine();
    writer.write(String.valueOf(allLangs.size()));
    for (String x : allLangs) {
      writer.newLine();
      writer.write(x);
    }

    reader.close();
    writer.close();
  }
}
