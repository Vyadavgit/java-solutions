package Q55LongestPalindromicSubstring;

// Time complexity: O(n^3)
// Space complexity: O(1)
class Solution1 {
    public static String longestPalindrome(String s) {
        for (int length = s.length(); length > 0; length--) { // length = 5, 4 ... 1
            for (int start = 0; start <= s.length() - length; start++) { // start = 0, 1 ... 4
                if (check(start, start + length, s)) { // narrow down from bigger lengths to smaller one
                    return s.substring(start, start + length);
                }
            }
        }

        return "";
    }

    private static boolean check(int i, int j, String s) {
        int left = i;
        int right = j - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("apppppplllle"));
    }
}