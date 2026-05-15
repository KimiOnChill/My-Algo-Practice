package YalgoTraining.Block_2.Competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//? set wil contain unsorted crosses
//? how to track was there an intersection for each other intervals?

public class C5_1 {
      public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String line = reader.readLine().trim();
        String[] lineArr = line.split("\\s+");
        int firstBase = Integer.parseInt(lineArr[0]);
        int firstRange = Integer.parseInt(lineArr[1]);
        ArrayList <Integer> firstGap = new ArrayList<Integer>();

        for (int i = firstBase - firstRange; i <= firstBase + firstRange; i++) {
          if (i > 0) {firstGap.add(i);}
        }

        Set <Integer> commonPoints = new HashSet<>();
        Integer[] wasCrossed= new Integer[n-1];

        for (int i = 2; i <= n; i++) {
          String newline = reader.readLine().trim();
          String[] newlineArr = newline.split("\\s+");
          int base = Integer.parseInt(newlineArr[0]);
          int range = Integer.parseInt(newlineArr[1]);

          for (int j = base - range; j <= base + range; j++) {
            if (firstGap.contains(j)) {
              commonPoints.add(j);
              wasCrossed[i-2] = 1;
            }
          }
        }

        // if (wasCrossed.includes(0)) {
        //   writer.write(String.valueOf(-1));
        // } else {
        //   writer.write(String.valueOf(commonPoints.get(commonPoints.size()-1)));
        // }

        reader.close();
        writer.close();
    }
}
