import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Palindrome {

    public static boolean checkForPalindrome(String value){
        Stack<Character> stack = new Stack<Character>();
        Queue<Character> queue = new LinkedList<Character>();
                
        for (int i = 0; i < value.length(); i++) {
            char symbol = Character.toLowerCase(value.charAt(i));
            queue.add(symbol);
            stack.push(symbol);
        }
                
        for (int i = 0; i < value.length(); i++) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }
        
        return true;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
       System.out.println(checkForPalindrome("aabaa"));

    }

}
