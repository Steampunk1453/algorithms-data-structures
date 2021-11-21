package array.string.glovo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    // Leetcode --> easy
    // Write an algorithm that returns the first non-repeated character in a string. For example:
    //
    //Input: ABCA
    //
    //Output: B
    //
    //Input: BCABAC
    //
    //Output: null
    //
    //Input: BAC
    //
    //Output: B
    //
    //Input: GlovoAtGlovo
    //
    //Output: A
    //
    //Input: What is the first non-repeated character?
    //
    //Output: W

    public String getFirstNonRepeatedCharacter(String input) {
        String result = null;
        Map<Character, Integer> map = new HashMap<>();
        for (Character character : input.toCharArray()) {
            if (map.containsKey(character)) {
                Integer value = map.get(character);
                map.put(character, value + 1);
            } else {
                map.put(character, 1);
            }
        }
        for (Character character : input.toCharArray()) {
            Integer times = map.get(character);
            if (times == 1) {
                result = character.toString();
                break;
            }
        }
        return result;
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
    public boolean isValidString(String input) {
        Stack<Character> stack = new Stack<>();
        for (Character character : input.toCharArray()) {
            if (character.equals('(')) {
                stack.push(')');
            } else if (character.equals('{')) {
                stack.push('}');
            } else if (character.equals('[')) {
                stack.push(']');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (!character.equals(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidString1(String input) {
        // Initialize hash map with mappings. This simply makes the code easier to read.
        HashMap<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<>();

        for (Character character : input.toCharArray()) {
            // If the current character is a closing bracket.
            if (mappings.containsKey(character)) {
                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();
                // If the mapping for this bracket doesn't match the stack'input top element, return false.
                if (topElement != mappings.get(character)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(character);
            }
        }
        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }


    public boolean isValidString2(String input) {
        // Initialize hash map with mappings. This simply makes the code easier to read.
        HashMap<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // If the current character is a closing bracket.
            if (mappings.containsKey(c)) {
                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();
                // If the mapping for this bracket doesn't match the stack'input top element, return false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }
        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }

}
