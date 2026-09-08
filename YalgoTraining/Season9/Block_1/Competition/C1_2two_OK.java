package YalgoTraining.Season9.Block_1.Competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// go throught every needed place to check if it will fall into the event.
// check (place - eventStart) % 2 to update current strength  

public class C1_2two_OK {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] lineArr = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(lineArr[0]); // events amount
        int m = Integer.parseInt(lineArr[1]); // places amount

        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] strength = new int[n];
        
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().trim().split(" ");
            starts[i] = Integer.parseInt(line[0]);
            ends[i] = Integer.parseInt(line[1]);
            strength[i] = Integer.parseInt(line[2]);
        }

        for (int i = 0; i < m; i++) {
            int place = Integer.parseInt(reader.readLine().trim());
            int curretnStrength = 0;
            for (int j = 0; j < n; j++) {
                if (place >= starts[j] && place <= ends[j]) {
                    curretnStrength += (place - starts[j]) % 2 == 0 ? strength[j]  : strength[j] * (-1);
                    // if ((place - starts[j]) % 2 == 0) {
                    //     curretnStrength += strength[j];
                    // } else {
                    //     curretnStrength -= strength[j];
                    // }
                }
            }
            writer.write(String.valueOf(curretnStrength));
            writer.newLine();
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