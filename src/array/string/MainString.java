package array.string;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class MainString {

    public static void main(String[] args) {
        // 1.1 Is Unique
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUnique(word));
        }

        // 1.3. URLify
        String input = "Mr John Smith    ";
        String delimiter = "%20";
        System.out.println(getUrl(input, delimiter));

        // 1.6 String Compression
        // https://stackoverflow.com/questions/23523597/split-string-into-repeated-characters
        String value = "aabcccccaaa";
        System.out.println(getCompression(value));

        Node next= null;
    }

    private static boolean isUnique(String value) {
        String valueFormatted = value.replaceAll("\\s+","").toLowerCase();
        String[] values = valueFormatted.split("");
        Hashtable<String, String> table = new Hashtable<>();

        for (String val : values) {
            String result = table.get(val);
            if (result != null) {
              return false;
            }
            table.put(val, val);
        }
        return true;
    }

    private static List<String> getMatches(String value) {
        String valueFormatted = value.replaceAll("\\s+","").toLowerCase();
        String[] values = valueFormatted.split("");
        Hashtable<String, String> table = new Hashtable<>();
        List<String> matches = new ArrayList<>();

        for (String val : values) {
            String result = table.get(val);
            if (result != null) {
                matches.add(val);
            }
            table.put(val, val);
        }
        return matches;
    }

    private static String getUrl(String value, String delimiter) {
        String trimInput = value.trim();
        String [] inputs = trimInput.split(" ");
        return String.join(delimiter, inputs);
    }

    private static String getCompression(String value) {
        String[] values = value.split("(?<=(.))(?!\\1)");
        StringBuilder sb = new StringBuilder();
        for (String val : values) {
            sb.append(val, 0, 1).append(val.length());
        }
        return sb.length() > value.length() ? value : sb.toString();
    }

}
