package Q17;

import java.util.ArrayList;
/*
asked by Google
* Q17. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
* */

// LEETCODE SUBMITTED SOLUTION
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            ArrayList<String> list = new ArrayList();
            return list;
        }
        return padRet("",digits);
    }

    static ArrayList<String> padRet(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        ArrayList<String> list  = new ArrayList<>();
        int digit = unprocessed.charAt(0)-'0'; // take initial char and convert to digit

        if(digit == 7 || digit==8 || digit == 9){
            if(digit==7){
                for(int i = (digit-2)*3; i < ((digit-2)*3)+4; i++){
                    char ch = (char) ('a'+i);
                    list.addAll(padRet(processed+ch, unprocessed.substring(1)));
                }
            }else if(digit==8){
                for(int i = (digit-2)*3+1; i < ((digit-2)*3+1)+3; i++){
                    char ch = (char) ('a'+i);
                    list.addAll(padRet(processed+ch, unprocessed.substring(1)));
                }
            }else{
                for(int i = (digit-2)*3+1; i < ((digit-2)*3+1)+4; i++){
                    char ch = (char) ('a'+i);
                    list.addAll(padRet(processed+ch, unprocessed.substring(1)));
                }
            }
        }else{
            for(int i = (digit-2)*3; i < ((digit-2)*3)+3; i++){
                char ch = (char) ('a'+i);
                list.addAll(padRet(processed+ch, unprocessed.substring(1)));
            }
        }
        return list;
    }
}