package optimization.greedy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    protected int getHighestProduct(int[] numbers) {
        int greatest = 0;
        int greatestAux = 0;
        int lowestAux = 0;
        int lowest = 0;

        for (int num : numbers) {
            if (num >= 0) {
                if (num > greatest) {
                    greatestAux = greatest;
                    greatest = num;
                } else if (num > greatestAux) {
                    greatestAux = num;
                }
            } else {
                if (num < lowest) {
                    lowestAux = lowest;
                    lowest = num;
                } else if (num < lowestAux) {
                    lowestAux = num;
                }
            }
        }

        int resultMax = greatest * greatestAux;
        int resultMin = lowest * lowestAux;

        return Math.max(resultMax, resultMin);
    }

    protected List<Double> sortTemperatures(double[] temperatures) {
        Map<Double, Boolean> map = getMap();
        List<Double> sortedTemperatures = new ArrayList<>();

        for (double temp : temperatures) {
            map.put(temp, true);
        }

        for (var entry : map.entrySet()) {
            if (entry.getValue()) {
                sortedTemperatures.add(entry.getKey());
            }
        }

        return sortedTemperatures;
    }

    private Map<Double, Boolean> getMap() {
        Map<Double, Boolean> map = new LinkedHashMap<>();

        map.put(97.0, false);
        map.put(97.1, false);
        map.put(97.2, false);
        map.put(97.3, false);
        map.put(97.4, false);
        map.put(97.5, false);
        map.put(97.6, false);
        map.put(97.7, false);
        map.put(97.8, false);
        map.put(97.9, false);
        map.put(98.0, false);
        map.put(98.1, false);
        map.put(98.2, false);
        map.put(98.3, false);
        map.put(98.4, false);
        map.put(98.5, false);
        map.put(98.6, false);
        map.put(98.7, false);
        map.put(98.8, false);
        map.put(98.9, false);
        map.put(99.0, false);

        return map;
    }

}
