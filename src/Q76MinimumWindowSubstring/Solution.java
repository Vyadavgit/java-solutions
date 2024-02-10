package Q76MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

// 76. Minimum Window Substring
// Given two strings s and t of lengths m and n respectively, return the minimum window 
// substring
//  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

// Example 1:
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

// TIME AND SPACE COMPLEXITY
// The time complexity of the minWindow method in the given code is O(n), where n is the length of the input string s. This is because the method iterates through the characters of s using the right pointer, and the while loop inside the for loop also iterates through the characters of s using the left pointer. Therefore, the overall time complexity is linear with respect to the length of s.
// The space complexity of the minWindow method is O(m), where m is the number of unique characters in the input string t. This is because the method uses two HashMaps, tMap and window, to store the counts of characters in t and the current window respectively. The space required by these HashMaps is proportional to the number of unique characters in t. In the worst case, when all characters in t are unique, the space complexity would be O(m).

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return ""; // return null if s has less chars than t

        Map<Character, Integer> tMap = new HashMap<>(); // map of t chars and count
        Map<Character, Integer> window = new HashMap<>(); // window of substrings and its counts

        // store all chars in tmap
        for(char c: t.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0)+1);

        int left = 0; // left pointer
        int count = 0; // count of t chars in window
        int len = Integer.MAX_VALUE; // min length of window of substrings
        int start = 0; // mindow window keeps shifting based on the new min window found next, hence remember the start of the last min window

        for(int right = 0; right < s.length(); right++){
            char r = s.charAt(right);

            // collect chars in window
            window.put(r, window.getOrDefault(r, 0)+1);

            // if current char exists in t then increment count
            if (tMap.containsKey(r) && window.get(r).intValue() <= tMap.get(r).intValue()) count++;

            // if all chars in t stored already in window, then begin minimizing the window
            while (count == t.length()){                
                // compare the length of window with last window 
                if(right - left + 1 < len){
                    // update len to current window
                    len = right - left + 1;
                    start  = left; // remember the left pointer of the minimum window
                }

                // if left character exists in t and the map
                char l = s.charAt(left++); // get leftmost character and move the left pointer
                if (tMap.containsKey(l)) {
                    if (window.get(l).intValue() == tMap.get(l).intValue()) count--;
                    window.put(l, window.get(l)-1);
                }

            }

        }


        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }
}