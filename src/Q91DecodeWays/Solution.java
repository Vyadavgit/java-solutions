package Q91DecodeWays;

import java.util.HashMap;
import java.util.Map;

// Q91. Decode Ways
// A message containing letters from A-Z can be encoded into numbers using the following mapping:
// 'A' -> "1"
// 'B' -> "2"
// ...
// 'Z' -> "26"

// To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

// "AAJF" with the grouping (1 1 10 6)
// "KJF" with the grouping (11 10 6)
// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

// Given a string s containing only digits, return the number of ways to decode it.

// The test cases are generated so that the answer fits in a 32-bit integer.

// Example 1:
// Input: s = "12"
// Output: 2
// Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

// TIME AND SPACE COMPLEXITY
// The time complexity of the numDecodings method is O(n), where n is the length of the input string s. This is because the method uses recursion to explore all possible combinations of decoding, and in the worst case scenario, it will explore all substrings of s.
// The space complexity of the numDecodings method is O(n), where n is the length of the input string s. This is because the method uses a memoization map to store previously computed results, and the size of the map will grow with the length of s. Additionally, the recursion stack will also consume space proportional to the length of s.
public class Solution {

    public static void main(String[] args) {
        System.out.println(numDecodings("1201234"));    
    }

    public static int numDecodings(String s) {
        Map<String, Integer> memo = new HashMap<>(); 
        return recursionCount(s, 0, memo);
    }

    public static int recursionCount(String s, int count, Map<String, Integer> memo){
        // edge case 
        if(s.charAt(0) == '0') return count += 0;
        // base cond
        if(s.length() == 1) count += 1;
        else{
            // check if the result is already memorized
            if(memo.containsKey(s)){
                return count += memo.get(s);
            }
            
            // without i.e single char
            if (s.charAt(1) != '0') {
                count = recursionCount(s.substring(1, s.length()), count, memo);   
            }

            // with i.e double char
            if (Integer.parseInt(s.substring(0, 2)) < 27) {
                if (s.length() == 2) {
                    count += 1;
                }else{
                    count = recursionCount(s.substring(2, s.length()), count, memo);   
                }
            }
            
            // memorize the result
            memo.put(s, count);
        }        
        return count;
    }
}
