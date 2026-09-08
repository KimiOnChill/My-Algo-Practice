package YalgoTraining.Season9.Block_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class I_SocksAndShirts {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int a = Integer.parseInt(reader.readLine());
    int b = Integer.parseInt(reader.readLine());
    int c = Integer.parseInt(reader.readLine());
    int d = Integer.parseInt(reader.readLine());

    int m = a >= b ? b+1 : a+1;
    int n = c >= d ? d+1 : c+1;

    String res = m + " " + n;

    writer.write (res);

    reader.close();
    writer.close();
  }
}
