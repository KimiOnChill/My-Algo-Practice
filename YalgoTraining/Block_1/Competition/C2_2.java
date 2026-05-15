package YalgoTraining.Block_1.Competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class C2_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = reader.readLine().trim().split(" ");
        double n = Double.parseDouble(nums[0]); // blanket's first side
        double m = Double.parseDouble(nums[1]); // blanket's second side
        double h = Double.parseDouble(nums[2]); // bag's first side
        double w = Double.parseDouble(nums[3]); // bag's second side
        int folds = 0;

        if (n > m) {
            double bench = n;
            n = m;
            m = bench;
        }
        if (h > w) {
            double bench = h;
            h = w;
            w = bench;
        }

        while (n > h || m > w) {
            if (n > h) {
                h *= 2;
            } else {
                w *= 2;
            }
            folds++;
        }

        writer.write(String.valueOf(folds));
        reader.close();
        writer.close();
    }
}
