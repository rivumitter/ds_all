package stack;

import java.util.ArrayDeque;

public class BalancedParenthesisMain {

    public static void main(String[] args) {

        String str = "[{}]((()))";

        System.out.println(checkBalanced(str));

    }

    private static boolean checkBalanced(String str) {

        ArrayDeque<Character> characterDeque = new ArrayDeque<>();

        for(Character ch : str.toCharArray()) {
            if(!characterDeque.isEmpty() && characterDeque.peek().equals('(') && ch.equals(')')) {
                characterDeque.pop();
            }
            else if(!characterDeque.isEmpty() && characterDeque.peek().equals('{') && ch.equals('}')) {
                characterDeque.pop();
            }
            else if(!characterDeque.isEmpty() && characterDeque.peek().equals('[') && ch.equals(']')) {
                characterDeque.pop();
            }
            else
                characterDeque.push(ch);
        }

        return characterDeque.isEmpty();
    }
}
