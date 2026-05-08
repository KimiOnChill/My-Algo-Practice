package YalgoTraining.Block_1.Competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
//! map of the whole model will cause memory acseed

public class C1_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] lineArr = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(lineArr[0]); // events amount
        int m = Integer.parseInt(lineArr[1]); // places amount
        HashMap<Integer, Integer> wave = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] eventArr = reader.readLine().trim().split(" ");
            int from = Integer.parseInt(eventArr[0]);
            int to = Integer.parseInt(eventArr[1]);
            int strength = Integer.parseInt(eventArr[2]);
            int tracking = 1;

            for (int j = from; j <= to; j++) {
                if (wave.containsKey(j)) {
                    int bench = wave.get(j);
                    wave.put(j, bench + strength * tracking);
                } else {
                    wave.put(j, strength * tracking);
                }
                tracking = tracking > 0 ? -1 : 1;
            }
        }

        for (int i = 0; i < m; i++) {
            int place = Integer.parseInt(reader.readLine().trim());
            if (wave.containsKey(place)) {
                writer.write(String.valueOf(wave.get(place)));
                writer.newLine();
            } else {
                writer.write(String.valueOf(0));
                writer.newLine();
            }
        }

        reader.close();
        writer.close();
    }
}

/*
2 6
1 6 7
3 7 2
1
2
3
6
7
8
*/