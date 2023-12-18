package Q49GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// 49. Group Anagrams

//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

//Example 1:
//
//        Input: strs = ["eat","tea","tan","ate","nat","bat"]
//        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

// Time: O(N*K*LogK)
// space: O(N*K)

class Bruteforce_vk {

    // O(N*K*LogK)
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map  = new HashMap<>(); // space: O(N)
        for (int i = 0; i < strs.length; i++){ // O(N)
            collect(strs[i], map);
        }

        List<List<String>> stringLists = new ArrayList<>();
        stringLists.addAll(map.values()); // space O(N*K) whree N is the number of strings and K is the length of the
                                            // longest string
        return stringLists;
    }

    private static boolean collect(String s, HashMap<String, List<String>> map){
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // O(K*logK)
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(chars));
        if (map.containsKey(String.valueOf(stringBuilder))){
            map.get(String.valueOf(stringBuilder)).add(s);
            return true;
        }
        List<String> list = new ArrayList<>();
        list.add(s);
        map.put(stringBuilder.toString(), list);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

}