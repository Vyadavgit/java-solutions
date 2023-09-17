package Q20ValidParentheses;

// 72 / 95 testcases passed
/*
Time Complexity: O(n)
Space Complexity: O(n)
* */
public class Bruteforce_vk {
    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));;
    }

    public static boolean isValid(String s) {
        if (s.length() <= 1 || s.length() % 2 != 0){
            return false;
        }

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)== '(' || s.charAt(i)== '{' || s.charAt(i)== '['){
                push(s.charAt(i));
                if(strStack.length() > s.length()/2){
                    return false;
                }
            }else {
                if(top() == '(' && s.charAt(i) == ')'){
                    pop();
                }else if(top() == '{' && s.charAt(i) == '}'){
                    pop();
                }else if(top() == '[' && s.charAt(i) == ']'){
                    pop();
                }else{
                    return false;
                }
            }
        }

        return true;
    }

    public static StringBuilder strStack = new StringBuilder();

    // push
    public static void push(char c){
        strStack.append(c);
    }

    // pop
    public static void pop(){
        strStack.deleteCharAt(strStack.length()-1);
    }

    // return top
    public static char top(){
        return strStack.charAt(strStack.length()-1);
    }
}
