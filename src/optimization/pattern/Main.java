package optimization.pattern;

import java.util.HashMap;
import java.util.Map;

public class Main {

    protected int getMissingNumber(int[] numbers) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int num : numbers) {
            map.put(num, true);
        }

        for (int num : numbers) {
            int result = num - 1;
            if (result >= 0 && !map.getOrDefault(result, false)) {
                return result;
            }
        }

        return 0;
    }

}
