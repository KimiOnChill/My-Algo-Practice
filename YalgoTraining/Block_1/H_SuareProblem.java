package YalgoTraining.Block_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class H_SuareProblem {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int a = Integer.parseInt(reader.readLine());
    int b = Integer.parseInt(reader.readLine());
    int c = Integer.parseInt(reader.readLine());

    if (a == 0 && b != Math.pow(c,2)) {
      writer.write("NO SOLUTION");
      reader.close();
      writer.close();
      return;
    } else if ( c < 0 || (Math.pow(c,2) - b) % a != 0 ) {
      writer.write("NO SOLUTION");
      reader.close();
      writer.close();
    } else if (a == 0 && b == Math.pow(c,2)) {
      writer.write("MANY SOLUTIONS");
      reader.close();
      writer.close();
      return;
    } else {
      double x = (Math.pow(c,2) - b) / a;
      int result = (int) Math.round(x);
      writer.write(String.valueOf(result));
    }  

    reader.close();
    writer.close();
  }
}
