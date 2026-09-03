package CodeRun.JAVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n7ThreOnes_OK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer n = Integer.parseInt(reader.readLine().trim());
        int[] f = new int[36];

        f[0] = 0;
        f[1] = 2;
        f[2] = 4;
        f[3] = 7;

        for (int i = 4; i <= n; i++) {
            f[i] = f[i-1] + f[i-2] + f[i-3];
        }

        writer.write(String.valueOf(f[n]));

        reader.close();
        writer.close();
    }
}
