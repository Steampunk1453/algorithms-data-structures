package hash.tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTable {

    // Write a function that returns the intersection of two arrays.
    // The intersection is a third array that contains all values contained with the first two arrays.
    // Intersection of [1,2,3,4,5] and [0,2,4,6,8] is [2,4].
    // Complexity must be O(N)
    protected List<Integer> getIntersection(int[] array1, int[] array2) {
        List<Integer> intersections = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : array1) {
            map.put(num, true);
        }
        for (int num : array2) {
            if (map.getOrDefault(num, false)) {
                intersections.add(num);
            }
        }
        return intersections;
    }

    // Write a function that accepts an array of strings and returns the first duplicate value it finds.
    // ["a","b","c","d","c","e","f"] function should return "c" since duplicated within the array.
    // Complexity must be O(N)
    protected String getFirstDuplicate(String[] array) {
        Map<String, Boolean> map = new HashMap<>();
        for (String value : array) {
            if (map.getOrDefault(value, false)) {
                return value;
            } else {
                map.put(value, true);
            }
        }
        return null;
    }

    // Write a function that accepts a string that contains all the letters of the alphabet except one
    // and returns the missing letter. The string "the quick brown box jumps over a lazy dog" contains all
    // the letters of the alphabet except the letter "f"
    // Complexity must be O(N)
    protected String getMissingLetter(String input) {
        char[] inputChars = input.toCharArray();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Map<Character, Boolean> map = new HashMap<>();

        for (char ch : inputChars) {
            map.put(ch, true);
        }
        for (char letter : alphabet) {
            if (!map.getOrDefault(letter, false)) {
                return String.valueOf(letter);
            }
        }
        return null;
    }

    // Write a function that returns the first non duplicated character in a string.
    // The string "minimum" has two characters that only exist once the "n" and the "u"
    // so your function should return the "n", since it occurs first.
    // Complexity must be O(N)
    protected String getFirstNonDuplicatedCharacter(String input) {
        char[] inputChars = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : inputChars) {
            if (map.getOrDefault(ch, 0) == 0) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        for (char ch : inputChars) {
            if (map.get(ch) == 1) {
                return String.valueOf(ch);
            }
        }
        return null;
    }

}



