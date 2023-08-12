package Q3LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/*
3. Longest Substring Without Repeating Characters

        Given a string s, find the length of the longest
        substring
        without repeating characters.

        Example 1:

        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
*/
// Time complexity: O(n)
// Space complexity: O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;

        Map<Character, Integer> map = new HashMap();

        for(int lastPos = 0, iterator = 0; iterator < n; iterator++){
            if(map.containsKey(s.charAt(iterator))){
                lastPos = Math.max(map.get(s.charAt(iterator)), lastPos);
            }

            ans = Math.max(ans, iterator - lastPos + 1);
            map.put(s.charAt(iterator), iterator+1);
        }

        return ans;
    }
}
