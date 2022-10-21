package array.string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void getLongestCommonPrefix() {
        // Given
        Main main = new Main();
        String[] input = {"flower","flow","flight"};
        // When
        String result = main.getLongestCommonPrefixHorizontal(input);
        String result1 = main.getLongestCommonPrefixVertical(input);
        // Then
        assertEquals(result, "fl");
        assertEquals(result, "fl");
    }

    @Test
    void dontGetLongestCommonPrefix() {
        // Given
        Main main = new Main();
        String[] input = {"dog","racecar","car"};
        // When
        String result = main.getLongestCommonPrefixHorizontal(input);
        String result1 = main.getLongestCommonPrefixVertical(input);
        // Then
        assertEquals(result, "");
        assertEquals(result1, "");
    }

    @Test
    void getLengthLastWord() {
        // Given
        Main main = new Main();
        String input = "Hello World Spanish";
        // When
        int result = main.getLengthLastWord(input);
        // Then
        assertEquals(result, 7);
    }

    @Test
    void dontExistLastWord() {
        // Given
        Main main = new Main();
        String input = "";
        // When
        int result = main.getLengthLastWord(input);
        // Then
        assertEquals(result, 0);
    }

    @Test
    void isValidPalindrome() {
        // Given
        Main main = new Main();
        String input = "A man, a plan, a canal: Panama";
        // When
        boolean result = main.isValidPalindrome(input);
        // Then
        assertTrue(result);
    }

    @Test
    void isNotValidPalindrome() {
        // Given
        Main main = new Main();
        String input = "race a car";
        // When
        boolean result = main.isValidPalindrome(input);
        // Then
        assertFalse(result);
    }


    @Test
    void isPalindrome() {
        // Given
        Main main = new Main();
        String input = "allivessevilla";
        // When
        boolean result = main.isPalindrome(input);
        // Then
        assertTrue(result);
    }


    @Test
    void reverseVowels() {
        // Given
        Main main = new Main();
        String input = "hello";
        // When
        String result = main.reverseVowels(input);
        // Then
        assertEquals(result, "holle");
    }

    @Test
    void detectCapital() {
        // Given
        Main main = new Main();
        String input = "USA";
        // When
        boolean result = main.detectCapital(input);
        boolean result1 = main.detectCapitalUse(input);
        // Then
        assertTrue(result);
        assertTrue(result1);
    }

    @Test
    void detectCapital1() {
        // Given
        Main main = new Main();
        String input = "leetcode";
        // When
        boolean result = main.detectCapital(input);
        boolean result1 = main.detectCapitalUse(input);
        // Then
        assertTrue(result);
        assertTrue(result1);
    }

    @Test
    void detectCapital2() {
        // Given
        Main main = new Main();
        String input = "Google";
        // When
        boolean result = main.detectCapital(input);
        boolean result1 = main.detectCapitalUse(input);
        // Then
        assertTrue(result);
        assertTrue(result1);
    }


    @Test
    void isNotCapital() {
        // Given
        Main main = new Main();
        String input = "FlaG";
        // When
        boolean result = main.detectCapital(input);
        boolean result1 = main.detectCapitalUse(input);
        // Then
        assertFalse(result);
        assertFalse(result1);
    }

    @Test
    void runLengthEncoding() {
        // Given
        Main main = new Main();
        String input = "wwwwaaadexxxxxx";
        // When
        String result = main.runLengthEncoding(input);
        String result1 = main.lengthEncoding(input);
        // Then
        assertEquals(result, "4w3a1d1e6x");
        assertEquals(result, "4w3a1d1e6x");
    }

    @Test
    void runLengthEncoding1() {
        // Given
        Main main = new Main();
        String input = "BBBBBBBBBBBBNBBBBBBBBBBBBNNNBBBBBBBBBBBBBBBBBBBBBBBBNBBBBBBBBBBBBBB";
        // When
        String result = main.lengthEncoding(input);
        // Then
        assertEquals(result, "12B1N12B3N24B1N14B");
    }

    @Test
    void getStringCompression() {
        // Given
        Main main = new Main();
        String input = "aabcccccaaa";
        // When
        String result = main.getStringCompression(input);
        // Then
        assertEquals(result, "a2b1c5a3");
    }

    @Test
    void getMostCommonWordWithOneBanned() {
        // Given
        Main main = new Main();
        String input = "Bob hit a ball, the hit BALL flew far after it was  hit.";
        String[] banned = {"hit"};
        // When
        String result = main.getMostCommonWord(input, banned);
        // Then
        assertEquals(result, "ball");
    }


    @Test
    void getMostCommonWordWithTwoBanned() {
        // Given
        Main main = new Main();
        String input = "Bob hit a ball, the hit BALL flew far after it was was hit.";
        String[] banned = {"hit", "ball"};
        // When
        String result = main.getMostCommonWord(input, banned);
        String result1 = main.mostCommon(input, banned);
        // Then
        assertEquals(result, "was");
    }

    @Test
    void getConsecutiveCharacters() {
        // Given
        Main main = new Main();
        String input = "hooraaaaaaaaaaay";
        // When
        int result = main.getConsecutiveCharacters(input);
        int result1 = main.maxPower(input);
        // Then
        assertEquals(result, 11);
        assertEquals(result1, 11);
    }

    @Test
    void getConsecutiveCharacters1() {
        // Given
        Main main = new Main();
        String input = "tourist";
        // When
        int result = main.getConsecutiveCharacters(input);
        int result1 = main.maxPower(input);
        // Then
        assertEquals(result, 1);
        assertEquals(result1, 1);
    }

    @Test
    void getThousandSeparator() throws ParseException {
        // Given
        Main main = new Main();
        int input = 987;
        int input1 = 1234;
        int input2 = 123456789;
        int input3 = 0;
        // When
        String result = main.getThousandSeparator(input);
        String result1 = main.getThousandSeparator(input1);
        String result2 = main.getThousandSeparator(input2);
        String result3 = main.getThousandSeparator(input3);
        String result4 = main.thousandSeparator(input1);
        String result5 = main.thousandSeparator(input2);
        // Then
        assertEquals(result, "987");
        assertEquals(result1, "1.234");
        assertEquals(result2, "123.456.789");
        assertEquals(result3, "0");
        assertEquals(result4, "1.234");
        assertEquals(result5, "123.456.789");
    }

    @Test
    void getTruePathCrossing() {
        // Given
        Main main = new Main();
        char[] path ={ 'N', 'E', 'S', 'W', 'W' };
        String paths = "NESWW";
        // When
        boolean result = main.isPathCrossing(path);
        boolean result1 = main.isPath(paths);
        boolean result2 = main.isPathCross(paths);
        // Then
        assertTrue(result);
        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    void getFalsePathCrossing() {
        // Given
        Main main = new Main();
        char[] path ={ 'N', 'E', 'S'};
        String paths = "NES";
        // When
        boolean result = main.isPathCrossing(path);
        boolean result1 = main.isPath(paths);
        boolean result2 = main.isPathCross(paths);
        // Then
        assertFalse(result);
        assertFalse(result1);
        assertFalse(result2);
    }

    @Test
    void isEquivalent() {
        // Given
        Main main = new Main();
        String[] word = {"abc", "d", "defg"};
        String[] word1 = {"abcddefg"};
        // When
        boolean result = main.isEquivalent(word, word1);
        // Then
        assertTrue(result);
    }

    @Test
    void isNotEquivalent() {
        // Given
        Main main = new Main();
        String[] word = {"a", "cb"};
        String[] word1 = {"ab", "c"};
        // When
        boolean result = main.isEquivalent(word, word1);
        // Then
        assertFalse(result);
    }

    @Test
    void getGoalParserInterpretation() {
        // Given
        Main main = new Main();
        String input = "G()(al)";
        String input1 = "G()()()()(al)";
        String input2 = "(al)G(al)()()G";
        // When
        String result = main.getGoalParserInterpretation(input);
        String result1 = main.getGoalParserInterpretation(input1);
        String result2 = main.getGoalParserInterpretation(input2);
        // Then
        assertEquals(result, "Goal");
        assertEquals(result1, "Gooooal");
        assertEquals(result2, "alGalooG");
    }

    @Test
    void getReformatPhoneNumber() {
        Main main = new Main();
        String input = "1-23-45 6";
        String input1 = "123 4-567";
        String input2 = "123 4-5678";
        String input3 = "12";
        String input4 = "--17-5 229 35-39475 ";
        // When
        String result = main.getReformatPhoneNumber(input);
        String result1 = main.getReformatPhoneNumber(input1);
        String result2 = main.getReformatPhoneNumber(input2);
        String result3 = main.getReformatPhoneNumber(input3);
        String result4 = main.getReformatPhoneNumber(input4);
        // Then
        assertEquals(result, "123-456");
        assertEquals(result1, "123-45-67");
        assertEquals(result2, "123-456-78");
        assertEquals(result3, "12");
        assertEquals(result4, "175-229-353-94-75");
    }

    @Test
    void mergeStringsAlternately() {
        // Given
        Main main = new Main();
        String input = "abc";
        String input1 = "pqr";
        String input2 = "abcd";
        String input3 = "pq";
        String input4 = "ab";
        String input5 = "pqrs";
        // When
        String result = main.mergeStringsAlternately(input, input1);
        String result1 = main.mergeStringsAlternately(input2, input3);
        String result2 = main.mergeStringsAlternately(input4, input5);
        // Then
        assertEquals(result, "apbqcr");
        assertEquals(result1, "apbqcd");
        assertEquals(result2, "apbqrs");
    }

    @Test
    void getSecondLargestDigit() {
        // Given
        Main main = new Main();
        String input = "dfa12321afd";
        // When
        int result = main.getSecondLargestDigit(input);
        // Then
        assertEquals(result, 2);
    }

    @Test
    void getSecondLargestDigit1() {
        // Given
        Main main = new Main();
        String input = "abc1111";
        // When
        int result = main.getSecondLargestDigit(input);
        // Then
        assertEquals(result, -1);
    }

    @Test
    void firstUniqChar() {
        // Given
        Main main = new Main();
        String input = "leetcode";
        // When
        int result = main.firstUniqChar(input);
        // Then
        assertEquals(result, 0);
    }

    @Test
    void firstUniqChar1() {
        // Given
        Main main = new Main();
        String input = "loveleetcode";
        // When
        int result = main.firstUniqChar(input);
        // Then
        assertEquals(result, 2);
    }

    @Test
    void firstUniqChar2() {
        // Given
        Main main = new Main();
        String input = "aabb";
        // When
        int result = main.firstUniqChar(input);
        // Then
        assertEquals(result, -1);
    }

    @Test
    void isValidParentheses() {
        // Given
        Main main = new Main();
        String input = "()";
        // When
        boolean result = main.isValidParentheses(input);
        // Then
        assertTrue(result);
    }

    @Test
    void isValidParentheses1() {
        // Given
        Main main = new Main();
        String input = "()[]{}";
        // When
        boolean result = main.isValidParentheses(input);
        // Then
        assertTrue(result);
    }

    @Test
    void isValidParentheses2() {
        // Given
        Main main = new Main();
        String input = "(]";
        // When
        boolean result = main.isValidParentheses(input);
        // Then
        assertFalse(result);
    }

    @Test
    void isValidParentheses3() {
        // Given
        Main main = new Main();
        String input = "([)]";
        // When
        boolean result = main.isValidParentheses(input);
        // Then
        assertFalse(result);
    }

    @Test
    void isValidParentheses4() {
        // Given
        Main main = new Main();
        String input = "{[]}";
        // When
        boolean result = main.isValidParentheses(input);
        // Then
        assertTrue(result);
    }

    @Test
    void longestCommonPrefix() {
        // Given
        Main main = new Main();
        String[] input = {"flower", "flow", "flight"};
        String output = "fl";
        // When
        String result = main.longestCommonPrefix(input);
        // Then
        assertEquals(result, output);
    }

    @Test
    void longestCommonPrefix1() {
        // Given
        Main main = new Main();
        String[] input = {"cir", "car"};
        String output = "c";
        // When
        String result = main.longestCommonPrefix(input);
        // Then
        assertEquals(result, output);
    }


    @Test
    void longestCommonPrefixReturnEmpty() {
        // Given
        Main main = new Main();
        String[] input = {"dog","racecar","car"};
        String output = "";
        // When
        String result = main.longestCommonPrefix(input);
        // Then
        assertEquals(result, output);
    }

    @Test
    void reverseString() {
        // Given
        Main main = new Main();
        // When
        String result = main.reverse("Hello");
        // Then
        assertEquals(result, "olleH");
    }

    @Test
    void reverseStringReturnEmpty() {
        // Given
        Main main = new Main();
        // When
        String result = main.reverse("");
        // Then
        assertEquals(result, "");
    }
    @Test
    void getLongestWord() {
        // Given
        Main main = new Main();
        String input = "I love dogs";
        // When
        String result = main.getLongestWord(input);
        // Then
        assertEquals(result, "love");
    }

    @Test
    void getLongestWord1() {
        // Given
        Main main = new Main();
        String input = "Hello world123 567";
        // When
        String result = main.getLongestWord(input);
        // Then
        assertEquals(result, "world123");
    }

    @Test
    void getLongestWord2() {
        // Given
        Main main = new Main();
        String input = "fun&!! time";
        // When
        String result = main.getLongestWord(input);
        // Then
        assertEquals(result, "time");
    }

    @Test
    void removeAtBeginning() {
        Main main = new Main();
        assertEquals("bc", main.remove("abc", 'a'));
        assertEquals("bc", main.removeRecursive("abc", 'a'));
        assertEquals("bcdefgh", main.removeRecursive("abcdefgh", 'a'));
        assertEquals("bcdefgh", main.removeRecursive("abcdefgh", 'a'));
    }

    @Test
    void removeAtMiddle() {
        Main main = new Main();
        assertEquals("abd", main.remove("abcd", 'c'));
        assertEquals("abd", main.removeRecursive("abcd", 'c'));
    }

    @Test
    void removeAtEnd() {
        Main main = new Main();
        assertEquals("abc", main.remove("abcd", 'd'));
        assertEquals("abc", main.removeRecursive("abcd", 'd'));
    }

    @Test
    void cornerCases() {
        Main main = new Main();
        // empty string test
        assertEquals("", main.remove("", 'd'));
        // all removable character test
        assertEquals("", main.remove("aaaaaaaaaaaaaa", 'a'));
        // all but one removable characters
        assertEquals("b", main.remove("aaaaaaaaaaaaaab", 'a'));
    }

    @Test
    void backspaceCompareBruteForce() {
        // Given
        Main main = new Main();
        String s = "ab#c";
        String t = "ad#c";
        // When
        boolean result = main.backspaceCompareBruteForce(s, t);
        // Then
        assertTrue(result);
    }

    @Test
    void backspaceCompareBruteForce1() {
        // Given
        Main main = new Main();
        String s = "ab##";
        String t = "c#d#";
        // When
        boolean result = main.backspaceCompareBruteForce(s, t);
        // Then
        assertTrue(result);
    }

    @Test
    void backspaceCompareBruteForce2() {
        // Given
        Main main = new Main();
        String s = "y#fo##f";
        String t = "y#f#o##f";
        // When
        boolean result = main.backspaceCompareBruteForce(s, t);
        // Then
        assertTrue(result);
    }

    @Test
    void backspaceCompareBruteForceReturnFalse() {
        // Given
        Main main = new Main();
        String s = "a#c";
        String t = "b";
        // When
        boolean result = main.backspaceCompareBruteForce(s, t);
        // Then
        assertFalse(result);
    }

    @Test
    void backspaceCompareBruteForceReturnFalse1() {
        // Given
        Main main = new Main();
        String s = "Ab#z";
        String t = "ab#z";
        // When
        boolean result = main.backspaceCompareBruteForce(s, t);
        // Then
        assertFalse(result);
    }

    @Test
    void backspaceCompareOptimal() {
        // Given
        Main main = new Main();
        String s = "ab#c";
        String t = "ad#c";
        // When
        boolean result = main.backspaceCompareOptimal(s, t);
        // Then
        assertTrue(result);
    }

    @Test
    void backspaceCompareOptimal1() {
        // Given
        Main main = new Main();
        String s = "ab##";
        String t = "c#d#";
        // When
        boolean result = main.backspaceCompareOptimal(s, t);
        // Then
        assertTrue(result);
    }

    @Test
    void backspaceCompareOptimal2() {
        // Given
        Main main = new Main();
        String s = "y#fo##f";
        String t = "y#f#o##f";
        // When
        boolean result = main.backspaceCompareOptimal(s, t);
        // Then
        assertTrue(result);
    }

    @Test
    void backspaceCompareOptimalReturnFalse() {
        // Given
        Main main = new Main();
        String s = "a#c";
        String t = "b";
        // When
        boolean result = main.backspaceCompareOptimal(s, t);
        // Then
        assertFalse(result);
    }

    @Test
    void backspaceCompareOptimalReturnFalse1() {
        // Given
        Main main = new Main();
        String s = "Ab#z";
        String t = "ab#z";
        // When
        boolean result = main.backspaceCompareOptimal(s, t);
        // Then
        assertFalse(result);
    }

    @Test
    void lengthOfLongestSubstringBruteForce() {
        // Given
        Main main = new Main();
        String s = "abcabcbb";
        // When
        int result = main.lengthOfLongestSubstringBruteForce(s);
        // Then
        assertEquals(result, 3);
    }

    @Test
    void lengthOfLongestSubstringBruteForce1() {
        // Given
        Main main = new Main();
        String s = "bbbbb";
        // When
        int result = main.lengthOfLongestSubstringBruteForce(s);
        // Then
        assertEquals(result, 1);
    }

    @Test
    void lengthOfLongestSubstringBruteForce2() {
        // Given
        Main main = new Main();
        String s = "pwwkew";
        // When
        int result = main.lengthOfLongestSubstringBruteForce(s);
        // Then
        assertEquals(result, 3);
    }

    @Test
    void lengthOfLongestSubstringBruteForce3() {
        // Given
        Main main = new Main();
        String s = "abcbda";
        // When
        int result = main.lengthOfLongestSubstringBruteForce(s);
        // Then
        assertEquals(result, 4);
    }

    @Test
    void lengthOfLongestSubstringBruteForce4() {
        // Given
        Main main = new Main();
        String s = "";
        // When
        int result = main.lengthOfLongestSubstringBruteForce(s);
        // Then
        assertEquals(result, 0);
    }

    @Test
    void lengthOfLongestSubstringBruteForce5() {
        // Given
        Main main = new Main();
        String s = "abcbdca";
        // When
        int result = main.lengthOfLongestSubstringBruteForce(s);
        // Then
        assertEquals(result, 4);
    }


    @Test
    void lengthOfLongestSubstringOptimal() {
        // Given
        Main main = new Main();
        String s = "abcabcbb";
        // When
        int result = main.lengthOfLongestSubstring(s);
        // Then
        assertEquals(result, 3);
    }

    @Test
    void lengthOfLongestSubstringOptimal1() {
        // Given
        Main main = new Main();
        String s = "bbbbb";
        // When
        int result = main.lengthOfLongestSubstring(s);
        // Then
        assertEquals(result, 1);
    }

    @Test
    void lengthOfLongestSubstringOptimal2() {
        // Given
        Main main = new Main();
        String s = "pwwkew";
        // When
        int result = main.lengthOfLongestSubstring(s);
        // Then
        assertEquals(result, 3);
    }

    @Test
    void lengthOfLongestSubstringOptimal3() {
        // Given
        Main main = new Main();
        String s = "abcbda";
        // When
        int result = main.lengthOfLongestSubStringSet(s);
        // Then
        assertEquals(result, 4);
    }

    @Test
    void lengthOfLongestSubstringOptimal4() {
        // Given
        Main main = new Main();
        String s = "";
        // When
        int result = main.lengthOfLongestSubstring(s);
        // Then
        assertEquals(result, 0);
    }

    @Test
    void lengthOfLongestSubstringOptimal5() {
        // Given
        Main main = new Main();
        String s = "abcbdca";
        // When
        int result = main.lengthOfLongestSubstring(s);
        // Then
        assertEquals(result, 4);
    }

    @Test
    void lengthOfLongestSubstringOptimal6() {
        // Given
        Main main = new Main();
        String s = "abcabcbb";
        // When
        int result = main.lengthOfLongestSubstringOptimal(s);
        // Then
        assertEquals(result, 3);
    }

}
