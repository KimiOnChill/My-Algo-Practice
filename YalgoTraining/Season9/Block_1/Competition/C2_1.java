package YalgoTraining.Season9.Block_1.Competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class C2_1 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine().trim());
        String line = reader.readLine().trim();
        int oldCount = 0;

        for (int i = 0; i < n; i++) {
            if (line.charAt(i) == 'a' || line.charAt(i) == 'h') {
                int newCount = 1;
                int j = i + 1;
                boolean check = true;
                while (check && j < n) {
                    if (line.charAt(i) == 'a') {
                        if (line.charAt(j) == 'h') {
                            newCount++;
                        } else {
                            check = false;
                        }
                    } else {
                        if (line.charAt(j) == 'a') {
                            newCount++;
                        } else {
                            check = false;
                        }
                    }
                    i++;
                    j++;
                }
                if (oldCount < newCount) {
                    oldCount = newCount;
                }
                i = j - 1;
            }
        }

        writer.write(String.valueOf(oldCount));

        reader.close();
        writer.close();
    }
}
