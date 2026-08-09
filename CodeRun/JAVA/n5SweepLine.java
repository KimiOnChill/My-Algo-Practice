package CodeRun.JAVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class n5SweepLine {
    public static ArrayList<ArrayList<Integer>> qiuckSortFunction (ArrayList<ArrayList<Integer>> inputArr) {

        if (inputArr.size() <= 1) {return inputArr;}
        int pivot = inputArr.get(0).get(0);
        ArrayList<ArrayList<Integer>> leftArr = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> rightArr = new ArrayList<ArrayList<Integer>>();

        for (int i = 1; i < inputArr.size(); i++) {
            if (inputArr.get(i).get(0) < pivot) {
                leftArr.add(inputArr.get(i));
            } else {
                rightArr.add(inputArr.get(i));
            }
        }
    
        // int[] leftFurther = leftArr.stream().mapToInt(Integer::intValue).toArray();
        // int[] rightFurther = rightArr.stream().mapToInt(Integer::intValue).toArray();

        ArrayList<ArrayList<Integer>> leftRes = qiuckSortFunction(leftArr); //leftFurther
        ArrayList<ArrayList<Integer>> rightRes = qiuckSortFunction(rightArr); //rightFurther

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(leftRes);
        result.add(inputArr.get(0));
        result.addAll(rightRes);
        // System.arraycopy(leftRes, 0, result, 0, leftRes.size());
        // System.arraycopy(inputArr, 0, result, leftRes.size(), 1);
        // System.arraycopy(rightRes, 0, result, leftRes.size()+1, rightRes.size());

        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().trim().split(" ");
        Integer n = Integer.parseInt(line[0]);
        Integer m = Integer.parseInt(line[1]);

        HashMap<Integer, Integer> bordersMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String[] lineOfNums = reader.readLine().trim().split(" ");
            Integer first = Integer.parseInt(lineOfNums[0]);
            Integer second = Integer.parseInt(lineOfNums[1]);
            if (first <= second) {
                bordersMap.put(first, 1);
                bordersMap.put(second, -1);
            } else {
                bordersMap.put(second, 1);
                bordersMap.put(first, -1);
            }
        }

        System.out.println(bordersMap);
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (Map.Entry<Integer, Integer> entry : bordersMap.entrySet()) {
            list.add(new ArrayList<Integer>(Arrays.asList(entry.getKey(), entry.getValue())));
        }
        System.out.println(Arrays.toString(list.toArray()));

        ArrayList<ArrayList<Integer>> sortedList = new ArrayList<ArrayList<Integer>>(qiuckSortFunction(list));

        System.out.println(sortedList);

        HashMap<Integer, Integer>  mapOfTime = new HashMap<>();
        int lastNum = sortedList.get(sortedList.size()-1).get(0);
        Integer current = 0;
        for (int i = sortedList.get(0).get(0); i <= lastNum; i++) {
            if (sortedList.get(0).get(0) == i) {
                current += sortedList.get(0).get(1);
                sortedList.remove(0);
            }
            mapOfTime.put(i, current);
        }
        System.out.println("mapOfTime:");

        System.out.println(mapOfTime);

        String[] lastLine = reader.readLine().trim().split(" ");
        for (int i = 0; i <= m-1; i++) {
            Integer num = Integer.parseInt(lastLine[i]);
            String answer = mapOfTime.get(num).toString();
            writer.write(answer + " ");
        //     // if (i != m-1) {
        //     //     writer.write(answer + " ");
        //     // } else {
        //     //     writer.write(answer);
        //     // }
        }

        reader.close();
        writer.close();
    }
}
