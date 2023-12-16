package Q131PalindromePartitioning;

// 131. Palindrome Partitioning
//Given a string s, partition s such that every
//        substring
//        of the partition is a
//        palindrome
//        . Return all possible palindrome partitioning of s.

//Example 1:
//
//        Input: s = "aab"
//        Output: [["a","a","b"],["aa","b"]]

import java.util.ArrayList;
import java.util.List;

public class SolutionBackTrack {
    private static List<List<String>> partition(String s){
        List<List<String>> list = new ArrayList<>();
        backTrack(list, new ArrayList<>(), s, 0);
        return list;
    }

    private static void backTrack(List<List<String>> list, List<String> tempList, String s, int index){
        if(index == s.length()){
            list.add(new ArrayList<>(tempList));
        }else {
            for(int i = index; i < s.length(); i++){
                if(isPalindrome(s, index, i)){
                    tempList.add(s.substring(index, i+1));
                    backTrack(list, tempList, s, i+1); // i+1 is the partition point(begining of next partition)
                                                            // since index to i was a palindrome
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }

    private static boolean isPalindrome(String s, int low, int high){
        while (low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

}
