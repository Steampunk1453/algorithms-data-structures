package array.string.leetcode;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.lang.Math.min;

public class MainLeetCode {

    // Write a function to find the longest common prefix string amongst an array of strings.
    //
    //If there is no common prefix, return an empty string "".
    // Example 1:
    //Input: strs = ["flower","flow","flight"]
    //Output: "fl"

    //Example 2:
    //Input: strs = ["dog","racecar","car"]
    //Output: ""
    //Explanation: There is no common prefix among the input strings.

    // https://leetcode.com/problems/longest-common-prefix/

    // Horizontal scanning
    protected String getLongestCommonPrefixHorizontal(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    // Vertical scanning
    protected String getLongestCommonPrefixVertical(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    // Given a string s consists of some words separated by spaces, return the length of the last word in the string.
    //If the last word does not exist, return 0.
    //
    //A word is a maximal substring consisting of non-space characters only.
    //
    //
    //
    //Example 1:
    //
    //Input: s = "Hello World"
    //Output: 5
    //Example 2:
    //
    //Input: s = " "
    //Output: 0

    protected int getLengthLastWord(String input) {
        String trimInput = input.trim();
        String[] words = trimInput.split(" ");
        String lastWord = words[words.length - 1];
        return lastWord.length();
    }

    // Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    //
    //
    //
    //Example 1:
    //
    //Input: s = "A man, a plan, a canal: Panama"
    //Output: true
    //Explanation: "amanaplanacanalpanama" is a palindrome.
    //Example 2:
    //
    //Input: s = "race a car"
    //Output: false
    //Explanation: "raceacar" is not a palindrome.

    protected boolean isValidPalindrome(String input) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String alphanumeric = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String[] inputs = alphanumeric.split("");

        for (String letter : inputs) {
            stack.push(letter);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return alphanumeric.equals(sb.toString());
    }

    // Given a string s, reverse only all the vowels in the string and return it.
    //
    //The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
    //
    //
    //
    //Example 1:
    //
    //Input: s = "hello"
    //Output: "holle"
    //Example 2:
    //
    //Input: s = "leetcode"
    //Output: "leotcede"

    protected String reverseVowels(String input) {
        int j = 0;
        // Storing the vowels separately
        char[] str = input.toCharArray();
        StringBuilder vowel = new StringBuilder();
        for (char c : str) {
            if (isVowel(c)) {
                j++;
                vowel.append(c);
            }
        }
        // Placing the vowels in the reverse
        // order in the string
        for (int i = 0; i < str.length; i++) {
            if (isVowel(str[i])) {
                str[i] = vowel.charAt(--j);
            }
        }
        return String.valueOf(str);
    }

    private boolean isVowel(char c) {
        return (c == 'a' || c == 'A' || c == 'e'
                || c == 'E' || c == 'i' || c == 'I'
                || c == 'o' || c == 'O' || c == 'u'
                || c == 'U');
    }

    // We define the usage of capitals in a word to be right when one of the following cases holds:
    //
    //All letters in this word are capitals, like "USA".
    //All letters in this word are not capitals, like "leetcode".
    //Only the first letter in this word is capital, like "Google".
    //Given a string word, return true if the usage of capitals in it is right.
    //
    //
    //
    //Example 1:
    //
    //Input: word = "USA"
    //Output: true
    //Example 2:
    //
    //Input: word = "FlaG"
    //Output: false

    protected boolean detectCapital(String input) {
        String[] letters = input.split("");
        if (input.equals(input.toUpperCase())) {
            return true;
        } else if (input.equals(input.toLowerCase())) {
            return true;
        } else if (letters[0].equals(letters[0].toUpperCase())) {
            for (int i = 1; i < letters.length; i++) {
                if (letters[i].equals(letters[i].toUpperCase())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]*|.[a-z]*");
    }

    // There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
    //
    //The move sequence is represented by a string, and the character moves[i] represents its ith move. Valid moves are R (right), L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.
    //
    //Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to the right once, "L" will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.
    // Example 1:
    //
    //Input: moves = "UD"
    //Output: true
    //Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
    //Example 2:
    //
    //Input: moves = "LL"
    //Output: false
    //Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.
    //Example 3:
    //
    //Input: moves = "RRDD"
    //Output: false
    //Example 4:
    //
    //Input: moves = "LDRRLRUULR"
    //Output: false
    protected boolean robotReturnOrigin(String moves) {
        int x = 0, y = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }

    // Given an input string, write a function that returns the Run Length Encoded string for the input string.
    //For example, if the input string is “wwwwaaadexxxxxx”, then the function should return “4w3a1d1e6x”

    protected String runLengthEncoding(String input) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        char[] inputs = input.toCharArray();

        for (Character cha : inputs) {
            map.put(cha, 0);
        }
        for (Character cha : inputs) {
            if (map.containsKey(cha)) {
                Integer times = map.get(cha);
                map.put(cha, times + 1);
            }
        }
        for (Character cha : inputs) {
            if (map.containsKey(cha)) {
                sb.append(map.get(cha)).append(cha);
                map.remove(cha);
            }
        }
        return sb.toString();
    }

    protected String lengthEncoding(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int runLength = 1;
            while (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                runLength++;
                i++;
            }
            sb.append(runLength);
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    // 1.6 String compression --> Geeks for Geeks --> easy
    // aabcccccaaa --> a2b1c5a3

    protected String getStringCompression(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int count = 1;
            while (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(input.charAt(i));
            sb.append(count);
        }
        return sb.toString().length() < input.length() ? sb.toString() : input;
    }


    // 819. Most Common Word
    // Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
    // Output: "ball"

    protected String getMostCommonWord(String paragraph, String[] banneds) {
        String normalizedStr = paragraph.toLowerCase();
        String[] words = normalizedStr.split("\\W+");
        TreeMap<Integer, String> map = new TreeMap<>();
        Stack<String> stack = new Stack<>();

        Set<String> bannedWords = new HashSet<>();
        Collections.addAll(bannedWords, banneds);

        for (String word : words) {
            if (!bannedWords.contains(word)) {
                stack.push(word);
            }
        }
//        for (String banned : banneds) {
//            while (stack.contains(banned)) {
//                stack.remove(banned);
//            }
//        }
        for (String word : words) {
            int counter = 0;
            while (stack.contains(word)) {
                counter++;
                stack.remove(word);
            }
            if (counter != 0) {
                map.put(counter, word);
            }
        }
        return map.lastEntry().getValue();
    }

    protected String mostCommon(String paragraph, String[] banned) {

        // 1). replace the punctuations with spaces,
        // and put all letters in lower case
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        // 2). split the string into words
        String[] words = normalizedStr.split("\\s+");

        Set<String> bannedWords = new HashSet<>();
        Collections.addAll(bannedWords, banned);

        Map<String, Integer> wordCount = new HashMap<>();
        // 3). count the appearance of each word, excluding the banned words
        for (String word : words) {
            if (!bannedWords.contains(word))
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 4). return the word with the highest frequency
        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    protected String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = Arrays.stream(banned)
                .collect(Collectors.toSet());

        Map<String, Integer> count = new HashMap<>();

        Arrays.stream(paragraph.replaceAll("[^a-zA-Z0-9]+", " ").split(" "))
                .map(String::toLowerCase)
                // .peek(System.out::println)
                .filter(word -> !bannedSet.contains(word))
                .forEach(word -> count.put(word, count.getOrDefault(word, 0) + 1));

        return count.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

    // Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
    //
    //Return the power of the string.

    protected int getConsecutiveCharacters(String input) {
        char[] charArray = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            while (i + 1 < charArray.length && input.charAt(i) == input.charAt(i + 1)) {
                Character character = input.charAt(i);
                map.put(character, map.getOrDefault(character, 1) + 1);
                i++;
            }

        }
        return map.isEmpty() ? 1 : Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getValue();
    }

    protected int maxPower(String s) {
        int count = 0;
        int maxCount = 0;
        char previous = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == previous) {
                // if same as previous one, increase the count
                count++;
            } else {
                // else, reset the count
                count = 1;
                previous = c;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    // 1556. Thousand Separator
    // Given an integer n, add a dot (".") as the thousands separator and return it in string format

    protected String getThousandSeparator(int input) throws ParseException {
        String value = String.valueOf(input);
        Map<Integer, String> map = new HashMap<>();
        map.put(4, "#.###");
        map.put(5, "##.###");
        map.put(6, "###.###");
        map.put(7, "#.###.###");
        map.put(8, "##.###.###");
        map.put(9, "###.###.###");

        int length = value.length();
        if (length > 3) {
            String format = map.get(length);
            MaskFormatter formatter = new MaskFormatter(format);
            formatter.setValueContainsLiteralCharacters(false);
            return formatter.valueToString(input);
        }
        return value;
    }

    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        for (int i = sb.length() - 3; i >= 1; i -= 3) {
            sb.insert(i, ".");
        }
        return sb.toString();
    }

    // 1496. Path Crossing
    // Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east,
    //or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
    //
    //Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited.
    //Return false otherwise.

    protected boolean isPathCrossing(char[] path) {
        Map<String, Boolean> steps = new HashMap<>();
        String separator = "&";
        String initialStep = "0&0";
        steps.put(initialStep, true);
        int x = 0;
        int y = 0;
        for (Character position : path) {
            switch (position) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
            StringBuilder step = new StringBuilder(String.valueOf(x));
            step.append(separator);
            step.append(y);
            if (steps.getOrDefault(step.toString(), false)) {
                return true;
            }
            steps.put(step.toString(), false);
        }
        return false;
    }

    protected boolean isPath(String path) {
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();
        set.add(x + " " + y);

        for (Character position : path.toCharArray()) {
            switch (position) {
                case 'N':
                    y++;
                    break;
                case 'E':
                    x++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
            }
            if (set.contains(x + " " + y)) {
                return true;
            } else {
                set.add(x + " " + y);
            }
        }

        return false;
    }

    protected boolean isPathCross(String path) {
	/*
	Save each coordinate into a set and check every time whether that coordinates are already present
	in the set or not, if yes return true else add that string into set.
	Basically its a way to store coordinates
	*/
        HashSet<String> set = new HashSet<>();
        set.add("0,0");
        int[] a = new int[]{0, 0};
        for (int i = 0; i < path.length(); i++) {
            StringBuilder temp = new StringBuilder();
            char c = path.charAt(i);
            switch (c) {
                case 'N':
                    a[1]++;
                    break;
                case 'E':
                    a[0]++;
                    break;
                case 'S':
                    a[1]--;
                    break;
                case 'W':
                    a[0]--;
            }
            temp.append(a[0]).append(",").append(a[1]);
            if (set.contains(temp.toString())) return true;
            set.add(temp.toString());
        }
        return false;
    }

    // 1662. Check If Two String Arrays are Equivalent
    // Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
    //
    //A string is represented by an array if the array elements concatenated in order forms the string.

    protected boolean isEquivalent(String[] word, String[] word1) {
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();

        for (int i = 0; i < Math.max(word.length, word1.length); i++) {
            if (i < word.length) {
                first.append(word[i]);
            }
            if (i < word1.length) {
                second.append(word1[i]);
            }
        }

        return first.toString().equals(second.toString());
    }

    // 1678. Goal Parser Interpretation
    // You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". The interpreted strings are then concatenated in the original order.
    //
    //Given the string command, return the Goal Parser's interpretation of command.

    protected String getGoalParserInterpretation(String input) {
        String result = input.split("")[0];
        String[] elements = input.split("");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < elements.length; i++) {
            String item = elements[i];
            if (item.equals("(") && elements[i + 1].equals("a")) {
                sb.append("al");
            } else if (item.equals("(")) {
                sb.append("o");
            } else if (item.equals("G")) {
                sb.append("G");
            }
        }

        return sb.toString();
    }

    protected String getGoalParser(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }

    // 1694. Reformat Phone Number
    protected String getReformatPhoneNumber(String input) {
        String formatInput = input.replaceAll("[\\-\\s]", "");
        StringBuilder result = new StringBuilder();
        int length = formatInput.length();
        String[] elements = formatInput.split("");

        for (int i = 0; i < elements.length; ) {
            while (formatInput.substring(i, elements.length).length() > 4) {
                result.append(formatInput, i, i + 3);
                result.append("-");
                i += 3;
            }
            String subItem = formatInput.substring(i, elements.length);
            int subItemLength = subItem.length();
            switch (subItemLength) {
                case 2:
                case 3:
                    result.append(formatInput, i, length);
                    i = length;
                    break;
                case 4:
                    result.append(formatInput, i, i + 2);
                    i += 2;
                    result.append("-");
                    result.append(formatInput, i, length);
                    i = length;
                    break;
            }
        }
        return result.toString();
    }

    protected String reformatNumber(String number) {
        number = number.replace("-", "").replace(" ", "");
        int len = number.length();

        if (len == 2 || len == 3)
            return number;
        StringBuilder sb = new StringBuilder(number);
        int i = 3;
        while (len > 4) {
            sb.insert(i, "-");
            len -= 3;
            i += 4;
        }
        while (len == 4) {
            i -= 1;
            sb.insert(i, "-");
            len -= 2;
        }
        return sb.toString();
    }

    protected String reformatNumber1(String number) {
        number = number.replace("-", "").replace(" ", "");
        int len = number.length();
        if (len == 0 || len == 1 || len == 2 || len == 3) {
            return number;
        }
        StringBuilder sb = new StringBuilder(number);
        int i = 3;
        while (len > 4) {
            sb.insert(i, "-");
            len -= 3;
            i += 4;
        }
        while (len == 4) {
            i -= 1;
            sb.insert(i, "-");
            len -= 2;
        }
        return sb.toString();
    }

    // 1768. Merge Strings Alternately

    protected String mergeStringsAlternately(String word, String word1) {
        StringBuilder sb = new StringBuilder(word);
        int minLength = min(word.length(), word1.length());

        for (int i = 0; i < minLength; i++) {
            int count = 1;
            while (count <= minLength) {
                sb.insert(i + count, word1.charAt(i));
                count++;
                i++;
            }
            if (word1.length() > word.length()) {
                sb.append(word1.substring(i));
            }
        }

        return sb.toString();
    }

    protected String mergeAlternately1(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < Math.min(word1.length(), word2.length())) {
            sb.append(word1.charAt(index));
            sb.append(word2.charAt(index));
            index++;
        }
        sb.append(word1.length() > word2.length() ? word1.substring(index) : word2.substring(index));
        return sb.toString();
    }

    // 1796. Second Largest Digit in a String
    // Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.
    //
    //An alphanumeric string is a string consisting of lowercase English letters and digits.

    protected int getSecondLargestDigit(String input) {
        String formatInput = input.replaceAll("[a-zA-Z]", "");
        Map<Character, Integer> map = new HashMap<>();

        for (Character cha : formatInput.toCharArray()) {
            if (map.containsKey(cha)) {
                map.put(cha, map.get(cha) + 1);
            } else {
                map.put(cha, 1);
            }
        }

        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(1)
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(-1);
    }

    public int secondHighest(String s) {
        int len = s.length();
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i)))
                nums.add(s.charAt(i) - '0');
        }

        int first = -1, second = -1;
        for (int i : nums) {
            if (i > first) {
                second = first;
                first = i;
            } else if (i > second && i != first)
                second = i;
        }
        return second;
    }

    // 1047. Remove All Adjacent Duplicates In String
    // 1544. Make The String Great

}
