package YalgoTraining.Block_2.Competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class C4_A_OK {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int scoredIntoFirst = 0;
    int scoredIntoSecond = 0;
    int n = Integer.parseInt(reader.readLine());
    HashMap<String, Integer> scoreByNames = new HashMap<String, Integer>();
    for (int i = 1; i <= n; i++) {
      String name = reader.readLine().trim();
      scoreByNames.put(name, 0);
    }

    int highestScore = 0;

    int m = Integer.parseInt(reader.readLine());
    for (int i = 1; i <= m; i++) {
      String line = reader.readLine().trim();
      String[] parts = line.split("[: ]");
      int firstScore = Integer.parseInt(parts[0]);
      int secondScore = Integer.parseInt(parts[1]);
      String nameShooter = parts[2];
      int alreadyScored = scoreByNames.get(nameShooter);
      if (firstScore != scoredIntoFirst) {
        int newPlayerScore = alreadyScored + firstScore - scoredIntoFirst;
        highestScore = highestScore > newPlayerScore ? highestScore : newPlayerScore; 
        scoreByNames.put(nameShooter, newPlayerScore);
        scoredIntoFirst = firstScore;
      } else {
        int newPlayerScore = alreadyScored + secondScore - scoredIntoSecond;
        highestScore = highestScore > newPlayerScore ? highestScore : newPlayerScore; 
        scoreByNames.put(nameShooter, newPlayerScore);
        scoredIntoSecond = secondScore;        
      }
    }

    String bestPlayer = null;
    for (Map.Entry<String, Integer> entry : scoreByNames.entrySet()) {
    if (entry.getValue().equals(highestScore)) {
        bestPlayer = entry.getKey();
        break;
      }
    }
    String result = "" + bestPlayer + " " + highestScore;
    writer.write(result);

    reader.close();
    writer.close();
  }
}
