package P290;

import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] tokens = s.split(" ");
        if (tokens.length != pattern.length()) return false;

        HashMap<Character, String> patternMap = new HashMap<>();
        for(int i = 0; i < pattern.length(); ++i){
            if (patternMap.containsValue(tokens[i])) {
                if(!tokens[i].equals(patternMap.get(pattern.charAt(i)))) return false;
            } else if (patternMap.containsKey(pattern.charAt(i))){
                return false;
            } else {
                patternMap.put(pattern.charAt(i), tokens[i]);
            }
        }

        return true;
    }

    public static void test(String pattern, String s, Boolean expected) {
        Boolean result = new Solution().wordPattern(pattern, s);
        System.out.println("Input: pattern = \""+pattern+"\", s = \""+s + "\"");
        System.out.println("Output: " + result);
        System.out.println("Expected: "+expected);
        System.out.println("Result: "+ (expected.equals(result) ? "Pass" : "Fail"));
    }

    public static void main(String[] args) {
        test("abba", "dog cat cat dog", true);
        test("abba", "dog cat cat fish", false);
        test("aaaa", "dog cat cat dog", false);
        test("abba", "dog dog dog dog", false);
    }
}