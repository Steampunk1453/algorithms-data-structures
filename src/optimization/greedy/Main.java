package optimization.greedy;

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

}
