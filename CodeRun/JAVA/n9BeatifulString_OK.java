package CodeRun.JAVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n9BeatifulString_OK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(reader.readLine().trim());
        String line = reader.readLine().trim(); // .split("")
        int maxGood = 0;

        for (int letterCode = 97; letterCode < 123; letterCode++) {
            char alphLetter = (char) letterCode;
            int left = 0;
            int changesNeeded = 0;

            for (int right = 0; right < line.length(); right ++) {
                if (line.charAt(right) != alphLetter) {
                    changesNeeded++;
                }
                while (changesNeeded > k) {
                    if (line.charAt(left) != alphLetter) {
                        changesNeeded--;
                    }
                    left++;
                }
                maxGood = Math.max (maxGood, right-left+1);
            }
        }
        
        writer.write(String.valueOf(maxGood));

        reader.close();
        writer.close();
    }
}
// a-z: 97 - 122