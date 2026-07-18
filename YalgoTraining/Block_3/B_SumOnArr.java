package YalgoTraining.Block_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class B_SumOnArr {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int amount = Integer.parseInt(reader.readLine().trim());
        // String[] inputArr = reader.readLine().trim().split("\\s+");
        // int Q = Integer.parseInt(reader.readLine().trim());
        int genStart = Integer.parseInt(reader.readLine().trim());
        ArrayList <Integer> generedArr = new ArrayList<>();

        generedArr.add(genStart);
        for (int i = 0; i < amount; i++) {
            int x = (11173 * generedArr.get(i) + 1) % 1000000007;
            generedArr.add(x);
        }  
        System.out.println(generedArr);     

        reader.close();
        writer.close();
    }
}
