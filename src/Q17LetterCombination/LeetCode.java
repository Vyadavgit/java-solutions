package Q17LetterCombination;// [17, 21, 25, 34, 37, 41, 61, 83, 92, 143, 148, 162, 206, 234, 268, 287, 442, 448, 645, 832, 852, 1672]

import java.util.ArrayList;

public class LeetCode {
    /*
  asked by Google
* Q17. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * */

    // CONCEPT
    public static void main(String[] args) {
        pad("", "23");
        System.out.println();
        System.out.println(padRet("","23"));
        System.out.println(padCount("","23"));
    }


    // print the letter combination
    static void pad(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.print(processed+" ");
            return;
        }

        int digit = unprocessed.charAt(0)-'0'; // take initial char and convert to digit
        for(int i = (digit-2)*3; i < ((digit-2)*3)+3; i++){
            char ch = (char) ('a'+i);
            pad(processed+ch, unprocessed.substring(1));
        }

    }

    // return in an array
    static ArrayList<String> padRet(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        ArrayList<String> list  = new ArrayList<>();
        int digit = unprocessed.charAt(0)-'0'; // take initial char and convert to digit
        for(int i = (digit-2)*3; i < ((digit-2)*3)+3; i++){
            char ch = (char) ('a'+i);
            list.addAll(padRet(processed+ch, unprocessed.substring(1)));
        }
        return list;
    }

    // return count
    static int padCount(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            return 1;
        }
        int count = 0;
        int digit = unprocessed.charAt(0)-'0'; // take initial char and convert to digit
        for(int i = (digit-2)*3; i < ((digit-2)*3)+3; i++){
            char ch = (char) ('a'+i);
            count = count + padCount(processed+ch, unprocessed.substring(1));
        }
        return count;
    }
}


