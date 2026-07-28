package CodeRun.JAVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class n3MinOnLine_OK {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] lineOfTwo = reader.readLine().trim().split(" ");
        int length = Integer.parseInt(lineOfTwo[0]);
        int window = Integer.parseInt(lineOfTwo[1]);
        String[] line = reader.readLine().trim().split(" ");

        if (length == 0) {
            writer.write(" ");
            reader.close();
            writer.close();
            return;
        }

        if (length == 1) {
            writer.write(String.valueOf(line[0]));
            reader.close();
            writer.close();
            return;
        }

        Deque<Integer> deq = new ArrayDeque<Integer>();
        Deque<Integer> qIndex = new ArrayDeque<Integer>();

        for (int i = 0; i < window; i++) {
            int current = Integer.parseInt(line[i]);

            if (deq.isEmpty() || current >= deq.getLast()){
                qIndex.add(i);
                deq.add(current);
            } else {
                while ((!deq.isEmpty()) && deq.getLast() > current) {
                    deq.removeLast();
                    qIndex.removeLast();  
                }
                qIndex.add(i);
                deq.add(current);
            }
        }

        writer.write(Integer.toString(deq.peek()));
        writer.newLine();
        // System.out.println("d:" + deq);
        // System.out.println("q:" + qIndex);

        for (int i = window; i < length; i++) {
            int current = Integer.parseInt(line[i]);

            if (qIndex.getFirst() <= i - window) {
                qIndex.removeFirst();
                deq.removeFirst();
            }

            if (deq.isEmpty() || current >= deq.getLast()){
                qIndex.add(i);
                deq.add(current);
            } else {
                while ((!deq.isEmpty()) && deq.getLast() > current) {
                    deq.removeLast();
                    qIndex.removeLast();  
                }
                qIndex.add(i);
                deq.add(current);
            }

            // System.out.println("d:" + deq);
            // System.out.println("q:" + qIndex);

            writer.write(Integer.toString(deq.peek()));
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
