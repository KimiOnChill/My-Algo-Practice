
package YalgoTraining.Season9.Block_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class G_HousesAndStores {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String line = reader.readLine().trim();

    int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

    int currentShop = -1;
    int currentHouse = 1;
    HashMap<Integer, Integer> closestShop = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {continue;}
      else if (arr[i] == 2) {currentShop = i;}
      else {
        if (currentShop != -1) {
          closestShop.put(currentHouse, i-currentShop);
        } else {
          closestShop.put(currentHouse, 0);
        }
        currentHouse++;
      }
    }
    
    currentHouse --;
    currentShop = -1;

    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] == 0) {continue;}
      else if (arr[i] == 2) {currentShop = i;}
      else {
        if (currentShop == -1) {
          continue;
        } else if (closestShop.get(currentHouse) > currentShop - i || closestShop.get(currentHouse) == 0) {
          closestShop.put(currentHouse, currentShop - i);
        }
        currentHouse--;
      }
    }

    int result = Collections.max(closestShop.values());
    writer.write(String.valueOf(result));

    reader.close();
    writer.close();
  }
}
// 2 0 1 1 0 1 0 2 1 2 -> 3
// 2 1 1 1 1 1 1 1 1 0 -> 8
// 2 1 1 1 1 1 1 1 1 2 -> 4
// 2 2 2 2 2 1 2 2 2 2 -> 1
// 0 1 1 1 1 1 1 1 1 2 -> 8
// 1 1 1 1 1 1 1 1 1 2 -> 9