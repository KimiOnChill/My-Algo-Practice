package YalgoTraining.Block_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_SumOnArr {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int amount = Integer.parseInt(reader.readLine().trim());
        String[] inputArr = reader.readLine().trim().split("\\s+");
        int Q = Integer.parseInt(reader.readLine().trim());
        int genStart = Integer.parseInt(reader.readLine().trim());

        

        reader.close();
        writer.close();
    }
}
