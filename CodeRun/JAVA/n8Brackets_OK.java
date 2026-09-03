package CodeRun.JAVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n8Brackets_OK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line;
        String str = reader.readLine().trim();

        if (str.length() == 0) {
            writer.write("yes");
            reader.close();
            writer.close();
            return;
        } else {
            line = str.split("");
        }
        Stack<Integer> stack = new Stack<>();

        for (String bracket : line) {
            int asciiCode = bracket.charAt(0);
            if (asciiCode == 40 || asciiCode == 91 || asciiCode == 123) {
                stack.push(asciiCode);
            } else if (asciiCode == 41) {
                if (!stack.empty() && stack.peek() == 40) {
                    stack.pop();
                } else {
                    writer.write("no");
                    reader.close();
                    writer.close();
                    return;
                }
            } else if (asciiCode == 93) {
                if (!stack.empty() && stack.peek() == 91) {
                    stack.pop();
                } else {
                    writer.write("no");
                    reader.close();
                    writer.close();
                    return;
                }
            } else if (asciiCode == 125) {
                if (!stack.empty() && stack.peek() == 123) {
                    stack.pop();
                } else {
                    writer.write("no");
                    reader.close();
                    writer.close();
                    return;
                }
            }
        }

        System.out.print(stack); //todo remove

        if (stack.empty()) {
            writer.write("yes");
        } else {
            writer.write("no");
        }

        reader.close();
        writer.close();
    }
}

/* ( (Open): 40
   ) (Close): 41
   [ (Open): 91 
   ] (Close): 93 
    { (Open): 123 
    } (Close): 125
 */