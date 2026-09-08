package YalgoTraining.Season10.Block_1.Training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(reader.readLine());
        String order = reader.readLine();
        String beggining = reader.readLine();

        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < beggining.length(); i++) {
            if (beggining.charAt(i) == '(' || beggining.charAt(i) == '[') {
                stack.push(beggining.charAt(i));
            } else {
                stack.pop();
            }
        }
        // System.out.print(stack);

        char cheepestOpen = 'q';
        boolean isCloseChipper = false;

        for (int i = 0; i < order.length(); i++) {
            char x = order.charAt(i);
            if (x == '(' || x == '['){
                cheepestOpen = x;
                break;
            } else {
                isCloseChipper = true;
            }
        }

        for (int i = beggining.length(); i < n; i++) {
            if (n-i >= stack.size() + 1) {
                if (isCloseChipper) {
                    isCloseChipper = false;
                    if (stack.peek() == '(') {
                        res.append(')');
                        stack.pop();
                    } else {
                        res.append(']');
                        stack.pop();  
                    }
                } else {
                    res.append(cheepestOpen);
                    stack.push(cheepestOpen);
                }
            } else {
                if (stack.peek() == '(') {
                    res.append(')');
                    stack.pop();
                } else {
                    res.append(']');
                    stack.pop();
                }
            }
        }

        writer.write(beggining + res);
        
        reader.close();
        writer.close();
    }
}
