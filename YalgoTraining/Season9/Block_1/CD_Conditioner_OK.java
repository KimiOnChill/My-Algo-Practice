
package YalgoTraining.Season9.Block_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CD_Conditioner_OK {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String line = reader.readLine().trim();
    String[] lineArr = line.split("\\s+");
    int tRoom = Integer.parseInt(lineArr[0]);
    int tSet = Integer.parseInt(lineArr[1]);
    String mode = reader.readLine().trim();
    int result = -110;

    switch (mode) {
      case "heat":
        result = tRoom < tSet ? tSet : tRoom;
        break;
      case "freeze":
        result = tRoom > tSet ? tSet : tRoom;
        break;
      case "auto":
        result = tSet;
        break;
      case "fan":
        result = tRoom;
        break;
      default:
        break;
    }

    writer.write(String.valueOf(result));

    reader.close();
    writer.close();
  }
}

// TESTS
// -50 50 heat = 50
// -50 50 freeze = -50
// -50 50 auto = 50
// -50 50 fan = -50
// 50 -50 heat = 50
// 50 -50 freeze = -50
// 50 -50 auto = -50
// 50 -50 fan = 50
// 0 0 heat = 0
// 0 0 freeze = 0
// 0 0 auto = 0
// 0 0 fan = 0