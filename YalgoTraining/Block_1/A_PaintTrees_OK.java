package YalgoTraining.Block_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class A_PaintTrees_OK {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String firstLine = reader.readLine().trim();
    String[] firstLineArr = firstLine.split("\\s+");
    int firstStart = Integer.parseInt(firstLineArr[0]);
    int firstRadius = Integer.parseInt(firstLineArr[1]);

    String secondLine = reader.readLine().trim();
    String[] secondLineArr = secondLine.split("\\s+");
    int secondStart = Integer.parseInt(secondLineArr[0]);
    int secondRadius = Integer.parseInt(secondLineArr[1]);

    long firstLeft = firstStart - firstRadius;
    long firstRigth = firstStart + firstRadius;

    long secondLeft = secondStart - secondRadius;
    long secondRigth = secondStart + secondRadius;
    long result;

    //when no intersections
    if (firstLeft > secondRigth || firstRigth < secondLeft) {
      result = (firstRigth - firstLeft + 1) + (secondRigth - secondLeft + 1); 
    } else {
      //case when there is an intersection
      long unionLeft = firstLeft < secondLeft ? firstLeft : secondLeft;
      long unionRight = firstRigth > secondRigth ? firstRigth : secondRigth;
      result = unionRight - unionLeft + 1;
    }

    writer.write(String.valueOf(result));

    reader.close();
    writer.close();
  }
}

/*
 * Input:
 * 0 7
 * 12 5
 * Output:
 * 25
 */