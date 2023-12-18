package Q49GroupAnagrams;

import java.util.*;
// 49. Group Anagrams

//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

//Example 1:
//
//        Input: strs = ["eat","tea","tan","ate","nat","bat"]
//        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

// Time: O(N*K*LogK)
// space: O(N*K)
public class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); // N space

        for (String word: strs){ // N time
            char[] chars = word.toCharArray();
            Arrays.sort(chars); // K*logK time
            String sortedString = new String(chars);

            if(!map.containsKey(sortedString)){
                map.put(sortedString, new ArrayList<>());
            }
            map.get(sortedString).add(word);
        }
        return new ArrayList<>(map.values()); // N*K space
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}