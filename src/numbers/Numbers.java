package numbers;

public class Numbers {

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
            num2 ++;
            value ++;
        }

        return value;
    }

    protected int multiply(int num1, int num2) {
        int result = 0;
        while (num2 > 0) {
            result += num1;
            num2 --;
        }
        return result;
    }

    protected int division(int num1, int num2) {
        int result = 0;
        while (result * num2 != num1) {
            result ++;
        }
        return result;
    }

    protected int division1(int num1, int num2) {
        int result = 0;
        while (num1 >= num2) {
            result ++;
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

    protected void countDown(int num) {
        if (num >= 0) {
            System.out.println(num);
            countDown(num - 1);
        }
    }

    protected int factorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    protected int factorialJJ(int num) {
        if (num <= 1) {
            return 1;
        }
        num = num * factorial(num - 1);
        return num;
    }

    protected int factorialJJ1(int num) {
        if (num > 1) {
            int aux;
            aux = factorialJJ(num - 1);
            num = num + aux;
        }
        return num;
    }

    protected int factorialWhile(int num) {
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

    protected int factorialFor(int num) {
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
        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return num == sum;
    }

    protected boolean isAmicableNumbers(int num, int num1) {
        int sum = 1;
        int sum1 = 1;
        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        for (int i = 2; i <= num1/2; i++) {
            if (num1 % i == 0) {
                sum1 += i;
            }
        }
        return sum == num1 && sum1 == num;
    }

    boolean isPrime(int number) {
        boolean prime = true;
        for (int i = 2; i <= number/2; i++) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }
       return prime;
    }

    boolean isCool(int number) {
        int sum = 1;
        for (int i = 2; i < number/2; i++) {
            sum += i;
            if (number == sum) {
                return true;
            }
        }
        return false;
    }

    void calculateArrayValues(double[] array) {
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

    void calculateArrayValues1(double[] array) {
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

    // 509. Fibonacci Number
    protected int fibonacciNum(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return fibonacciNum(num - 1) + fibonacciNum(num - 2);
    }

    protected int recursiveMulti(int num1, int num2) {
        int aux = num1;
        if (num2 == 1) {
            return num1;
        }
        aux += recursiveMulti(num1, num2 - 1);
        return aux;
    }

    protected int recursiveMultiJJ(int num1, int num2) {
        if (num2 == 1) {
            return num1;
        } else {
           num1 += recursiveMultiJJ(num1, num2 - 1);
        }
        return num1;
    }

}
