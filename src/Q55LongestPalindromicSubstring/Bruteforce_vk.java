package Q55LongestPalindromicSubstring;

// Time complexity: O(N^2)
// Space complexity: O(N)
public class Bruteforce_vk {
    public static String longestPalindrome(String s) { // O(n^2) times
        int max = Integer.MIN_VALUE;
        int substr_length;
        String substr;

        String ans = "";
        for (int i = 0; i < s.length(); i++) { // n times
            substr = retPalindrome(s, i);
            substr_length = substr.length();
            if(max < substr_length){
                max = substr_length;
                ans = substr;
            }
        }
        return ans;
    }

    public static String retPalindrome(String s, int pos){ // n times
        int start=pos, end=pos;
        while (start >= 0 && end <= s.length()-1){ // n/2
            if(s.charAt(start) != s.charAt(end)){
                break;
            }
            start--;
            end++;
        }
        start++;
        end--;
        String substr_evenCheck = s.substring(start, end+1);

        if(substr_evenCheck.length() % 2 != 0 && s.length() > 1){
            start = pos;
            end = pos + 1;
            while (start >= 0 && end <= s.length()-1){ // n/2
                if(s.charAt(start) != s.charAt(end)){
                    if(start == pos && end == pos + 1){
                        start = pos - 1;
                        end = pos + 1;
                        break;
                    }
                    break;
                }
                start--;
                end++;
            }
            start++;
            end--;
        }
        String substr_oddCheck = s.substring(start, end+1);
        String substr = substr_oddCheck.length() > substr_evenCheck.length() ? substr_oddCheck : substr_evenCheck;

//        System.out.println("start: "+ start + " end: "+ end);
//        System.out.println("returned: "+ substr);

        return substr;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("appppplllleee"));
    }
}
