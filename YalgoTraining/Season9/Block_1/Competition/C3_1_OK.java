package YalgoTraining.Season9.Block_1.Competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// count ' in the string's start
// mult count by 2 to access undeleted chars
// reverse string and repeat
// reserse again and add to result String

public class C3_1_OK {
  public static String reverse(String str) {
    return new StringBuilder(str).reverse().toString();
  }

  public static String corpStart(String str) {
    char[] chars = str.toCharArray();
    int count = 0;
    for (int i = 0; i < chars.length && chars[i] == '\''; i++) {
      count++;
    }
    if (count == 0) {
      return str;
    }

    StringBuilder processed = new StringBuilder();
    for (int i = count * 2; i < chars.length; i++) {
      processed.append(chars[i]);
    }
    return processed.toString();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String line = reader.readLine().trim();
    String[] lineArr = line.split("\\s+");
    StringBuilder result = new StringBuilder();

    for (String str : lineArr) {
      String corped = corpStart(str);
      String reversed = reverse(corped);
      String corped2 = corpStart(reversed);
      result.append(reverse(corped2));
    }

    String res = result.toString();

    writer.write(res);

    reader.close();
    writer.close();
  }
}

// yandex'''' 'algo''' trainings'''' -> yatrain
