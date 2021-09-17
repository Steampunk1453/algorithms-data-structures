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

}
