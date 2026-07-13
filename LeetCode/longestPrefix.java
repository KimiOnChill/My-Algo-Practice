package LeetCode;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class longestPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        ArrayList<Character> prefix = new ArrayList<>();
        
        for (char letter : strs[0].toCharArray()) {
            prefix.add(letter);
        }
        for (int x = 1; x < strs.length; x++){
            for (int i = strs[x].length(); i >= 0; i--) {
                if (i >= prefix.size()) break;
                if (strs[x].charAt(i) != prefix.get(i) && strs[x].length() <= prefix.size()){
                    for (int j = prefix.size() - 1; j >= i; j--) { 
                        prefix.remove(j);
                    }
                }
            }
        }

        String s = prefix.stream().map(String::valueOf).collect(Collectors.joining());

        return s;
    }

    public static void main(String[] args) {
        String[] str1 = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(str1));

        String[] str2 = { "dog", "racecar", "car" };
        System.out.println(longestCommonPrefix(str2));

        String[] str3 = { "" };
        System.out.println(longestCommonPrefix(str3));
        
        String[] str4 = { "flower" };
        System.out.println(longestCommonPrefix(str4));

        String[] str5 = { "ab", "a" };
        System.out.println(longestCommonPrefix(str5));
    }
}
