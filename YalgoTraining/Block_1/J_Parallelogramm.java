package YalgoTraining.Block_1;

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

          Double d12 = Math.pow((Math.pow(points.get(1).get(1) - points.get(1).get(0), 2) + Math.pow(points.get(2).get(1) - points.get(2).get(0), 2)), -2);
          Double d23 = Math.pow((Math.pow(points.get(2).get(1) - points.get(2).get(0), 2) + Math.pow(points.get(3).get(1) - points.get(3).get(0), 2)), -2);
          Double d34 = Math.pow((Math.pow(points.get(3).get(1) - points.get(3).get(0), 2) + Math.pow(points.get(4).get(1) - points.get(4).get(0), 2)), -2);
          Double d41 = Math.pow((Math.pow(points.get(4).get(1) - points.get(4).get(0), 2) + Math.pow(points.get(1).get(1) - points.get(1).get(0), 2)), -2);
          
          if (d12 != d34 || d23 != d41) {
            writer.write("NO");
            reader.close();
            writer.close();
            return;
          }

          //check ||
        }
        reader.close();
        writer.close();
    }
}