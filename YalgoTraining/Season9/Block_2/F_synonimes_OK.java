package YalgoTraining.Season9.Block_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class F_synonimes_OK {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(reader.readLine().trim());
    HashMap<String, String> firstMap = new HashMap<>();
    HashMap<String, String> secondMap = new HashMap<>();

    for (int i = 1; i < n+1; i++) {
      String line = reader.readLine().trim();
      String[] arrLine = line.split(" ");
      firstMap.put(arrLine[0], arrLine[1]);
      secondMap.put(arrLine[1], arrLine[0]);
    }

    // if there is always a match in input
    // isle add 2nd as if else (secondMap.containsKey(whatToFind)) and 3rd condition to return error
    String whatToFind = reader.readLine().trim();
    if (firstMap.containsKey(whatToFind)){
      writer.write(firstMap.get(whatToFind));
    } else {
      writer.write(secondMap.get(whatToFind));
    }

    reader.close();
    writer.close();
  }
}
