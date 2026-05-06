package YalgoTraining.Block_1.Competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class C1_1_OK {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] lineArr = reader.readLine().trim().split(" ");
    int rows = Integer.parseInt(lineArr[0]);
    int cols = Integer.parseInt(lineArr[1]);

    int result = 0;

    ArrayList<String> lines = new ArrayList<>();

    for (int i = 1; i <= rows; i++) {
      String line = reader.readLine();
      lines.add(line);
      for (int j = 0; j < cols; j++) {
        if (j != cols - 1 && line.charAt(j) == '.' && line.charAt(j+1) == '.') {
          result++;
        }

        if (i != 1) {
          String previousLine = lines.get(i-2);
          if (line.charAt(j) == '.' && previousLine.charAt(j) == '.') {
            result++;
          }
        }
      }
    }
    
    writer.write(String.valueOf(result));

    reader.close();
    writer.close();
  }
}
/*
3 4
..#.
#..#
..#.
*/
