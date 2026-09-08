package YalgoTraining.Season9.Block_0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//! time O(n^2) - is bad 
public class B_Oligopoly {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int inputLength = Integer.parseInt(reader.readLine());

    String line = reader.readLine().trim();
    String[] lineArr = line.split("\\s+");
    int[] moneyArr = Arrays.stream(lineArr).mapToInt(Integer::parseInt).toArray();

    if (inputLength == 1) {
      writer.write("1");
      reader.close();
      writer.close();
      return;
    }

    writer.write("0");

    for (int i = 1; i < inputLength; i++) {// result of this cycle is write 0 | 1
      long currentCompany = moneyArr[i];
      for (int j = 0; j < inputLength; j++) {
        if (j == i) {
          continue;
        }
        if (moneyArr[j] < currentCompany) {
          currentCompany += moneyArr[j];
        }
      }
      if (currentCompany > moneyArr[inputLength - 1]) {
        writer.newLine();
        writer.write("1");
      } else {
        writer.newLine();
        writer.write("0");
      }
    }

    reader.close();
    writer.close();
  }
}


/*
 * Input:
 * 4
 * 1 1 3 4
 * Output:
 * 0
 * 0
 * 1
 * 1
 */

//from ai with binary search
// long[] prefix = new long[inputLength];
//     prefix[0] = moneyArr[0];
//     for (int i = 1; i < inputLength; i++) {
//       prefix[i] = prefix[i-1] + moneyArr[i];
//     }

//     // For each i, sum of smaller = prefix[last_index_where_moneyArr[j] < moneyArr[i]]
//     for (int i = 1; i < inputLength; i++) {
//       // Binary search finds rightmost j where moneyArr[j] < moneyArr[i]
//       int left = 0, right = i - 1, pos = -1;
//       while (left <= right) {
//         int mid = (left + right) / 2;
//         if (moneyArr[mid] < moneyArr[i]) {
//           pos = mid;
//           left = mid + 1;
//         } else {
//           right = mid - 1;
//         }
//       }
//       long sumSmaller = (pos >= 0) ? prefix[pos] : 0;
//       long currentCompany = moneyArr[i] + sumSmaller;
      
//       if (currentCompany > moneyArr[inputLength - 1]) {
//         writer.newLine(); writer.write("1");
//       } else {
//         writer.newLine(); writer.write("0");
//       }
//     }