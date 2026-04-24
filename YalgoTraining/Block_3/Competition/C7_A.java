package YalgoTraining.Block_3.Competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class C7_A {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(reader.readLine());

    int result = 0;
    int leftPointer = 0;
    int balance = 0;

    String line = reader.readLine();

    for (int rightPointer = 0; rightPointer < n; rightPointer++){
      balance = line.charAt(rightPointer) == 'a' ? balance + 1 : balance - 1;
      if (balance == 0) {
        result++;
        balance = line.charAt(leftPointer) == 'a' ? balance - 1 : balance + 1;
        leftPointer++;
      }
    }

    writer.write(String.valueOf(result));

    reader.close();
    writer.close();
  }
}
