package CodeRun.JAVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class n1WordsCount_OK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap <String, Boolean> wordsMap = new HashMap<>();
        String input;
        while ((input = reader.readLine()) != null) {
            String[] line = input.split("\\s+");
            
            for (String word: line) {
                if (!word.isEmpty()){
                    if (!wordsMap.containsKey(word)) {
                        wordsMap.put(word, true);
                    }
                }
            }
        }
        System.out.println(wordsMap);
        writer.write(Integer.toString(wordsMap.size()));
        reader.close();
        writer.close();
    }
}