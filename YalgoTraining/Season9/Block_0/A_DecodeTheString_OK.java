package YalgoTraining.Season9.Block_0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A_DecodeTheString_OK {
 public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = reader.readLine();

    String result = "";
    int i = 0;
    while (i < input.length()) {
      char letter = '0';

      if(input.length() - i > 2 && input.charAt(i + 2) == '#'){
        String doubleDigit = "" + input.charAt(i) + input.charAt(i + 1);
        letter = (char) (Integer.parseInt(doubleDigit) + 96);
        i += 3;
      } else {
        int digit = Character.getNumericValue(input.charAt(i));
        letter = (char) (digit + 96);
        i++;
      }

      result += letter;
    }
    writer.write(result);

    reader.close();
    writer.close();
  }
}
/*
 * 1212# -> abl
 * 8512#12#15#23#15#18#12#4 -> helloworld
 * 1 -> a
 * 10# -> j
 */
