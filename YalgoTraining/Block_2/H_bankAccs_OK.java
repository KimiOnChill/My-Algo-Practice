package YalgoTraining.Block_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Set;

public class H_bankAccs_OK {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    HashMap<String, Integer> customers = new HashMap<>();
    String input;
    while ((input = reader.readLine()) != null) {
      input = input.trim();
      String[] line = input.split(" ");

      if (input.startsWith("DEPOSIT")) {
        if (customers.containsKey(line[1])) {
          int transit = customers.get(line[1]);
          customers.put(line[1], transit + Integer.parseInt(line[2]));
        } else {
          customers.put(line[1], Integer.parseInt(line[2]));
        }
      }

      else if (input.startsWith("WITHDRAW")) {
        if (customers.containsKey(line[1])) {
          int transit = customers.get(line[1]);
          customers.put(line[1], transit - Integer.parseInt(line[2]));
        } else {
          customers.put(line[1], 0 - Integer.parseInt(line[2]));
        }
      }

      else if (input.startsWith("BALANCE")) {
        if (customers.containsKey(line[1])) {
          writer.write(String.valueOf(customers.get(line[1])));
          writer.newLine();
        } else {
          writer.write("ERROR");
          writer.newLine();
        }
      }

      else if (input.startsWith("TRANSFER")) {
        if (customers.containsKey(line[1]) && customers.containsKey(line[2])) {
          int transitFirst = customers.get(line[1]);
          int transitSecond = customers.get(line[2]);
          customers.put(line[1], transitFirst - Integer.parseInt(line[3]));
          customers.put(line[2], transitSecond + Integer.parseInt(line[3]));
        }
        else if (!customers.containsKey(line[1]) && customers.containsKey(line[2])) {
          int transitSecond = customers.get(line[2]);
          customers.put(line[1], 0 - Integer.parseInt(line[3]));
          customers.put(line[2], transitSecond + Integer.parseInt(line[3]));
        }
        else if (customers.containsKey(line[1]) && !customers.containsKey(line[2])) {
          int transitFirst = customers.get(line[1]);
          customers.put(line[1], transitFirst - Integer.parseInt(line[3]));
          customers.put(line[2], Integer.parseInt(line[3]));
        }
        else if (!customers.containsKey(line[1]) && !customers.containsKey(line[2])) {
          customers.put(line[1], 0 - Integer.parseInt(line[3]));
          customers.put(line[2], Integer.parseInt(line[3]));
        }
      }

      else if (input.startsWith("INCOME")) {
        Set<String> names = customers.keySet();

        for (String name: names) {
          int currentValue = customers.get(name);
          if (customers.get(name) > 0) {
            int newValue = currentValue * Integer.parseInt(line[1]) / 100 + currentValue;
            customers.put(name, newValue);
          }
        }
      }
    }

    //System.out.println(customers);

    reader.close();
    writer.close();
  }
}
/*
DEPOSIT Ivanov 100
WITHDRAW Petrov 100
BALANCE Petrov
TRANSFER Ivanov Petrov 50
INCOME 5
*/