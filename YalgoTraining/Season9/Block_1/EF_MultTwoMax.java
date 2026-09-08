
package YalgoTraining.Season9.Block_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class EF_MultTwoMax {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = reader.readLine().trim();
        String[] lineArr = line.split("\\s+");

        HashMap<String, Integer> extrimes = new HashMap<>();

        if (lineArr.length == 2) {
            int a = Integer.parseInt(lineArr[0]);
            int b = Integer.parseInt(lineArr[1]);
            String res = a >= b ? b + " " + a : a + " " + b;
            writer.write(res);
            reader.close();
            writer.close();
            return;
        }

        if (lineArr.length == 3) {
            List<Integer> sorted = Arrays.stream(lineArr)
                    .map(s -> Integer.parseInt(s))
                    .sorted()
                    .collect(Collectors.toList());

            String res = sorted.get(1) * sorted.get(2) >= sorted.get(1) * sorted.get(0)
                    ? sorted.get(1) + " " + sorted.get(2)
                    : sorted.get(0) + " " + sorted.get(1);
            writer.write(res);
            reader.close();
            writer.close();
            return;
        }

        for (int i = 0; i < lineArr.length; i++) {
            int x = Integer.parseInt(lineArr[i]);
            if (x >= 0) {
                if (extrimes.containsKey("biggestPositive")) {
                    if (x >= extrimes.get("biggestPositive")) {
                            extrimes.put("bigPositive", extrimes.get("biggestPositive"));
                            extrimes.put("biggestPositive", x);
                    } else {
                        if (!extrimes.containsKey("bigPositive") || (x > extrimes.get("bigPositive") && x < extrimes.get("biggestPositive"))) {
                            extrimes.put("bigPositive", x);
                        }
                    }
                } else {
                    extrimes.put("biggestPositive", x);
                }

            } else {
                if (extrimes.containsKey("smallestNegative")) {
                    if (x <= extrimes.get("smallestNegative")) {
                            extrimes.put("smallNegative", extrimes.get("smallestNegative"));
                            extrimes.put("smallestNegative", x);
                    } else {
                        if (!extrimes.containsKey("smallNegative") || (x < extrimes.get("smallNegative") && x > extrimes.get("smallestNegative"))) {
                            extrimes.put("smallNegative", x);
                        }
                    }
                } else {
                    extrimes.put("smallestNegative", x);
                }
            }
        }

        System.out.println(extrimes);
        // System.out.println(extrimes.get("smallNegative"));
        // System.out.println(extrimes.get("smallestNegative"));
        // System.out.println(extrimes.get("smallNegative") * extrimes.get("smallestNegative"));

        String result = null;
        if (!extrimes.containsKey("bigPositive") && !extrimes.containsKey("biggestPositive")) {
            result = "" + extrimes.get("smallestNegative") + " " + extrimes.get("smallNegative");
        }
        else if (!extrimes.containsKey("smallNegative") && !extrimes.containsKey("smallestNegative")) {
            result = "" + extrimes.get("bigPositive") + " " + extrimes.get("biggestPositive");   
        }
        else {
            Integer multPositives = extrimes.get("bigPositive") * extrimes.get("biggestPositive");
            Integer multNegatives = extrimes.get("smallNegative") * extrimes.get("smallestNegative");
            result = multPositives >= multNegatives
            ? "" + extrimes.get("bigPositive") + " " + extrimes.get("biggestPositive")
            : "" + extrimes.get("smallestNegative") + " " + extrimes.get("smallNegative");
        }      

        writer.write(result);

        reader.close();
        writer.close();
    }
}
// 0 1 -> 0 1
// 2 -1 -> -1 2
// 1 1 -> 1 1
// 1 2 3 -> 2 3
// 3 2 1 -> 2 3
// -100 8 -1 -> -100 -1
// 1 1 1 -> 1 1
// 0 0 -1 -> 0 0
// -1 1 0 -2 3 -> 1 3
// -4 3 -5 2 5 -> -5 -4
// 2 2 2 2 3 3 -> 3 3
// -2 -2 -2 -2 -3 -3 -> -3 -3