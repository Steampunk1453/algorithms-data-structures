package math;

import java.util.HashMap;
import java.util.Map;

public class Main {

    protected int subtract(int num1, int num2) {
        int higher;
        int less;

        if (num1 >= num2) {
            higher = num1;
            less = num2;
        } else {
            higher = num2;
            less = num1;
        }

        int index = 0;

        while (index + less != higher) {
            index++;
        }

        return index;
    }

    protected int subtract1(int num1, int num2) {
        int value = 0;

        while (num1 > num2) {
            num2++;
            value++;
        }

        return value;
    }

    protected int multiply(int num1, int num2) {
        int result = 0;
        while (num2 > 0) {
            result += num1;
            num2--;
        }
        return result;
    }

    protected int multiplyRecursive(int num1, int num2) {
        if (num2 == 0) {
            return 0;
        } else {
            return num1 + multiplyRecursive(num1, num2 - 1);
        }
    }


    protected int division(int num1, int num2) {
        int result = 0;
        while (result * num2 != num1) {
            result++;
        }
        return result;
    }

    protected int division1(int num1, int num2) {
        int result = 0;
        while (num1 >= num2) {
            result++;
            num1 -= num2;
        }
        System.out.println("Rest: " + num1);
        return result;
    }

    protected int pow(int num, int exp) {
        int result = num;
        while (exp > 1) {
            result *= num;
            exp--;
        }
        return result;
    }

    protected int pow1(int num, int exp) {
        int result = 1;
        while (exp > 0) {
            result *= num;
            exp--;
        }
        return result;
    }

    protected int factorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    protected int factorial1(int num) {
        if (num == 0) {
            return 1;
        }
        int result = num;
        while (num > 1) {
            num--;
            result *= num;
        }
        return result;
    }

    protected int factorial2(int num) {
        if (num == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    protected boolean isPerfectNumber(int num) {
        int sum = 1;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return num == sum;
    }

    protected boolean isAmicableNumbers(int num, int num1) {
        int sum = 1;
        int sum1 = 1;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        for (int i = 2; i <= num1 / 2; i++) {
            if (num1 % i == 0) {
                sum1 += i;
            }
        }
        return sum == num1 && sum1 == num;
    }

    protected boolean isPrime(int number) {
        boolean prime = true;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }

    protected boolean isCool(int number) {
        int sum = 1;
        for (int i = 2; i < number / 2; i++) {
            sum += i;
            if (number == sum) {
                return true;
            }
        }
        return false;
    }

    protected void calculateArrayValues(double[] array) {
        double min = array[0];
        double max = array[0];
        double sum = 0;

        for (double value : array) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
            sum += value;
        }

        System.out.println("min: " + min);
        System.out.println("max: " + max);
        System.out.println("med: " + sum / array.length);
    }

    protected void calculateArrayValues1(double[] array) {
        double min = array[0];
        double max = array[0];
        double sum = 0;

        for (double value : array) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            sum += value;
        }

        System.out.println("min: " + min);
        System.out.println("max: " + max);
        System.out.println("med: " + sum / array.length);
    }

    // Input: s = "III"
    // Output: 3
    // Explanation: III = 3

    // Input: s = "LVIII"
    // Output: 58
    // Explanation: L = 50, V= 5, III = 3

    // Input: s = "MCMXCIV"
    // Output: 1994
    // Explanation: M = 1000, CM = 900, XC = 90 and IV = 4
    // Time complexity: O(n)
    // Space complexity: O(n)
    protected int romanToInteger(String romanNumber) {
        char[] romanItems = romanNumber.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int arrayLength = romanItems.length;
        int result = 0;

        for (int i = 0; i < arrayLength; i++) {
            int next = 0;
            int current = map.get(romanItems[i]);
            int nextIndex = i + 1;
            if (nextIndex < arrayLength) {
                next = map.get(romanItems[nextIndex]);
            }
            if (current < next) {
                result += next - current;
                i++;
            } else {
                result += current;
            }
        }
        return result;
    }

    // TODO Review to understand algorithm
    protected int sqrt(int x) {
        int low = 1; // mid always >= 1;
        int high = x;
        int answer = 0; // skip loop when high is 0
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= x / mid) {
                low = mid + 1;
                answer = mid;
            } else
                high = mid - 1;
        }
        return answer;
    }

}
