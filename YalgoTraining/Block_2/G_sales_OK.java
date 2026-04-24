package YalgoTraining.Block_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class G_sales_OK {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    TreeMap<String, TreeMap<String, Integer>> customers = new TreeMap<>();
    String input;
    while ((input = reader.readLine()) != null) {
      String[] line = input.split(" ");
      if (line.length % 3 == 0) {
        customers.putIfAbsent(line[0], new TreeMap<>());

        if (customers.get(line[0]).containsKey(line[1])) {
          int temp = customers.get(line[0]).get(line[1]);
          customers.get(line[0]).put(line[1], temp + Integer.parseInt(line[2]));
        } else {
          customers.get(line[0]).put(line[1], Integer.parseInt(line[2]));
        }
      }
    }

    for (Map.Entry<String, TreeMap<String, Integer>> outer : customers.entrySet()) {
      writer.write(outer.getKey() + ":");
      writer.newLine();
      for (Map.Entry<String, Integer> inner : outer.getValue().entrySet()) {
        writer.write(inner.getKey() + " " + inner.getValue());
        writer.newLine();
      }
    }

    // System.out.println(customers);
    reader.close();
    writer.close();

  }
}
