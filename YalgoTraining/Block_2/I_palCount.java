package YalgoTraining.Block_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;

// when i have map of chars i need to construct a string
// go through map and add to string each char Math.round(value/2)
// track uneven values to find if there will be a single middle char

public class I_palCount {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(reader.readLine());
    String line = reader.readLine();
    TreeMap<Character, Integer> letters = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      if (letters.containsKey(line.charAt(i))) {
        int transit = letters.get(line.charAt(i));
        letters.put(line.charAt(i), transit + 1);
      } else {
        letters.put(line.charAt(i), 1);
      }
    }

    StringBuilder str = new StringBuilder();
    int only = 0;
    for (char letter : letters.keySet()) {
        if (Math.round(letters.get(letter)/2) >= 1) {
            str.append(letter);
        } else if (letters.get(letter) == 1 && Character.getNumericValue(letter) > only) {
            only = (int) letter;
        }
    }

    String firstPart = str.toString();
    String secondPart = str.reverse().toString();
    if (only > 0) {
        String result = firstPart + (char) only + secondPart;
        writer.write(result);
    } else {
        String result = firstPart + secondPart;
        writer.write(result);
    }

    reader.close();
    writer.close();
  }
}
