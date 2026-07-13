package WInter2026;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class A_MinNumber_OK {
    public static String minimumNumber(String str) {
        HashMap <Character, Integer> mapOfDigits = new HashMap<>();
        Set <Integer> setOfDigits = new TreeSet<>();

        for (char num : str.toCharArray() ){
            setOfDigits.add(num - '0');
            if (mapOfDigits.containsKey(num)) {
                int transit = mapOfDigits.get(num);
                mapOfDigits.put(num, transit+1);
            } else {
                mapOfDigits.put(num, 1);
            }
        }
        ////System.out.println(mapOfDigits);
        ////System.out.println(str.toCharArray());

        StringBuilder gathered = new StringBuilder();
        ArrayList<Integer> setIntoArray = new ArrayList<>();
        for (Integer x : setOfDigits){
            setIntoArray.add(x);
        }

        if (setOfDigits.contains(0)) {
            Integer firstNum = setIntoArray.get(1);
            gathered.append(firstNum.toString());
            int transit = mapOfDigits.get(Character.forDigit(firstNum, 10));
            mapOfDigits.put(Character.forDigit(firstNum, 10), transit-1);
            for (int i = mapOfDigits.get('0'); i > 0; i--){
                gathered.append("0");
                int temp = mapOfDigits.get('0');
                mapOfDigits.put('0', temp-1);
                //// System.out.println(i);
            }
            setIntoArray.remove(0);
        }

        for (Integer digit : setIntoArray){
            Character num = Character.forDigit(digit, 10);
            while (mapOfDigits.get(num) > 0) {
                gathered.append(digit.toString());
                int transit = mapOfDigits.get(num);
                mapOfDigits.put(num, transit-1);
            }
        }        
        
        return gathered.toString();
    }


    public static void main(String[] args) {
        String str1 = "01"; // 202689
        System.out.println(minimumNumber(str1));
    }
}
