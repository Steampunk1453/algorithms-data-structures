package array.string.leetcode;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class MainStringTest {

    @Test
    void getLongestCommonPrefix() {
        // Given
        MainString main = new MainString();
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
        MainString main = new MainString();
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
        MainString main = new MainString();
        String input = "Hello World Spanish";
        // When
        int result = main.getLengthLastWord(input);
        // Then
        assertEquals(result, 7);
    }

    @Test
    void dontExistLastWord() {
        // Given
        MainString main = new MainString();
        String input = "";
        // When
        int result = main.getLengthLastWord(input);
        // Then
        assertEquals(result, 0);
    }

    @Test
    void isValidPalindrome() {
        // Given
        MainString main = new MainString();
        String input = "A man, a plan, a canal: Panama";
        // When
        boolean result = main.isValidPalindrome(input);
        // Then
        assertTrue(result);
    }

    @Test
    void isNotValidPalindrome() {
        // Given
        MainString main = new MainString();
        String input = "race a car";
        // When
        boolean result = main.isValidPalindrome(input);
        // Then
        assertFalse(result);
    }


    @Test
    void isPalindrome() {
        // Given
        MainString main = new MainString();
        String input = "allivessevilla";
        // When
        boolean result = main.isPalindrome(input);
        // Then
        assertTrue(result);
    }


    @Test
    void reverseVowels() {
        // Given
        MainString main = new MainString();
        String input = "hello";
        // When
        String result = main.reverseVowels(input);
        // Then
        assertEquals(result, "holle");
    }

    @Test
    void detectCapital() {
        // Given
        MainString main = new MainString();
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
        MainString main = new MainString();
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
        MainString main = new MainString();
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
        MainString main = new MainString();
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
        MainString main = new MainString();
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
        MainString main = new MainString();
        String input = "BBBBBBBBBBBBNBBBBBBBBBBBBNNNBBBBBBBBBBBBBBBBBBBBBBBBNBBBBBBBBBBBBBB";
        // When
        String result = main.lengthEncoding(input);
        // Then
        assertEquals(result, "12B1N12B3N24B1N14B");
    }

    @Test
    void getStringCompression() {
        // Given
        MainString main = new MainString();
        String input = "aabcccccaaa";
        // When
        String result = main.getStringCompression(input);
        // Then
        assertEquals(result, "a2b1c5a3");
    }

    @Test
    void getMostCommonWordWithOneBanned() {
        // Given
        MainString main = new MainString();
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
        MainString main = new MainString();
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
        MainString main = new MainString();
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
        MainString main = new MainString();
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
        MainString main = new MainString();
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
        MainString main = new MainString();
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
        MainString main = new MainString();
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
        MainString main = new MainString();
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
        MainString main = new MainString();
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
        MainString main = new MainString();
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
        MainString main = new MainString();
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
        MainString main = new MainString();
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
        MainString main = new MainString();
        String input = "dfa12321afd";
        // When
        int result = main.getSecondLargestDigit(input);
        // Then
        assertEquals(result, 2);
    }

    @Test
    void getSecondLargestDigit1() {
        // Given
        MainString main = new MainString();
        String input = "abc1111";
        // When
        int result = main.getSecondLargestDigit(input);
        // Then
        assertEquals(result, -1);
    }

    @Test
    void firstUniqChar() {
        // Given
        MainString main = new MainString();
        String input = "leetcode";
        // When
        int result = main.firstUniqChar(input);
        // Then
        assertEquals(result, 0);
    }

    @Test
    void firstUniqChar1() {
        // Given
        MainString main = new MainString();
        String input = "loveleetcode";
        // When
        int result = main.firstUniqChar(input);
        // Then
        assertEquals(result, 2);
    }

    @Test
    void firstUniqChar2() {
        // Given
        MainString main = new MainString();
        String input = "aabb";
        // When
        int result = main.firstUniqChar(input);
        // Then
        assertEquals(result, -1);
    }

    @Test
    void isValidParentheses() {
        // Given
        MainString main = new MainString();
        String input = "()";
        // When
        boolean result = main.isValidParentheses(input);
        // Then
        assertTrue(result);
    }

    @Test
    void isValidParentheses1() {
        // Given
        MainString main = new MainString();
        String input = "()[]{}";
        // When
        boolean result = main.isValidParentheses(input);
        // Then
        assertTrue(result);
    }

    @Test
    void isValidParentheses2() {
        // Given
        MainString main = new MainString();
        String input = "(]";
        // When
        boolean result = main.isValidParentheses(input);
        // Then
        assertFalse(result);
    }

    @Test
    void isValidParentheses3() {
        // Given
        MainString main = new MainString();
        String input = "([)]";
        // When
        boolean result = main.isValidParentheses(input);
        // Then
        assertFalse(result);
    }

    @Test
    void isValidParentheses4() {
        // Given
        MainString main = new MainString();
        String input = "{[]}";
        // When
        boolean result = main.isValidParentheses(input);
        // Then
        assertTrue(result);
    }

}
