package CodeRun.JAVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n6GoodLetters_OK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer n = Integer.parseInt(reader.readLine().trim());

        long prev = 0;
        long res = 0;
        
        for (int i = 0; i < n; i++) {
            long x = Integer.parseInt(reader.readLine().trim());
            res += Math.min(x, prev);
            prev = x;
        }

        writer.write(String.valueOf(res));

        reader.close();
        writer.close();
    }
}
