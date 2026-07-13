package YalgoTraining.Block_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A_PrefixSum_OK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int amount = Integer.parseInt(reader.readLine().trim());
        StringBuilder resultString = new StringBuilder();

        String inputStr = reader.readLine().trim();
        String[] inputArr = inputStr.split("\\s+");
        int prefix = 0;

        for (int i = 0; i < amount; i++) {
            prefix += Integer.parseInt(inputArr[i]);
            resultString.append(String.valueOf(prefix) + " ");
        }

        writer.write(resultString.toString());

        reader.close();
        writer.close();
    }
}
