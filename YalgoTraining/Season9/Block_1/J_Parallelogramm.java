package YalgoTraining.Season9.Block_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class J_Parallelogramm {
      public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine().trim());
        HashMap<Integer, List<Double>> points = new HashMap<>();

        for (int i = 1; i <= n; i++) {
          String line = reader.readLine().trim();
          double[] arr = Arrays.stream(line.split(" ")).mapToDouble(Double::parseDouble).toArray();
          int count = 1;
          for (int m = 0; m < arr.length; m+=2) {
            List<Double> values = new ArrayList<>();
            values.add(arr[m]);
            values.add(arr[m+1]);
            points.put(count, values);
            count++;
          }

          Double vektor1x = points.get(2).get(0) - points.get(1).get(0);
          Double vektor1y = points.get(2).get(1) - points.get(1).get(1);
          Double vektor2x = points.get(3).get(0) - points.get(2).get(0);
          Double vektor2y = points.get(3).get(1) - points.get(2).get(1);
          Double vektor3x = points.get(4).get(0) - points.get(3).get(0);
          Double vektor3y = points.get(4).get(1) - points.get(3).get(1);
          Double vektor4x = points.get(1).get(0) - points.get(4).get(0);
          Double vektor4y = points.get(1).get(1) - points.get(4).get(1);

          Double d12 = Math.pow((Math.pow (vektor1x, 2) + Math.pow(vektor1y, 2)), -2);
          Double d23 = Math.pow((Math.pow (vektor2x, 2) + Math.pow(vektor2y, 2)), -2);
          Double d34 = Math.pow((Math.pow (vektor3x, 2) + Math.pow(vektor3y, 2)), -2);
          Double d41 = Math.pow((Math.pow (vektor4x, 2) + Math.pow(vektor4y, 2)), -2);
         
          if (d12 != d34 || d23 != d41) {
            writer.write("NO");
            reader.close();
            writer.close();
            return;
          }
          
          if (vektor1x / vektor1y != vektor2x / vektor2y) {
            writer.write("NO");
            reader.close();
            writer.close();
            return;
          }
        }
        reader.close();
        writer.close();
    }
}