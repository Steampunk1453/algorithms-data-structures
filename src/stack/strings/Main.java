package stack.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    // Write a function that uses a stack to reverse a string
    // "abcde" to "edcba"
    protected String reverseString(String input) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] chars = input.toCharArray();
        for (Character ch : chars) {
            stack.push(ch);
        }
        while (!stack.empty()) {
            sb.append(stack.pop().toString());
        }
        return sb.toString();
    }

    // Leetcode --> easy
    // Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    //
    //An input string is valid when:
    //
    //Opening brackets are closed by the same type of closing brackets, and
    //
    //Opening brackets are closed in the correct order.
    //
    //Note that an empty string is also considered valid.
    //Examples:
    //
    //1 - "()" -> true
    //
    //2 - "()[]{}" -> true
    //
    //3 - "(]" -> false
    //
    //4 - ")(" -> false
    //
    //5 - "([)]" -> false
    //6 - "{[]}" -> true
    //
    //7 - ")" -> false
    //
    //8 - "([]" -> false
    //
    //9 - "{" -> false
    //
    //10 - "([)])" -> false
    //
    //11 - "(((((((((())))))))))" -> true
    // 12 - "" -> true
    protected boolean isValidString(String input) {
        Stack<Character> stack = new Stack<>();
        char[] chars = input.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (Character ch : chars) {
            Character character = stack.isEmpty() ? '#' : stack.peek();
            if (map.get(ch) == character) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

}
