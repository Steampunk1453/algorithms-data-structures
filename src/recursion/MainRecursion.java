package recursion;

public class MainRecursion {

    protected int factorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    protected  long factorial1(int num) {
        if (num >= 1)
            return num * factorial1(num - 1);
        else
            return 1;
    }

    protected long factorialWithOutRecursion(int num) {
        int i;
        int fact = 1;
        for(i = 1; i <= num; i++){
            fact = fact * i;
        }
        return fact;
    }

    protected int arraySum(int[] array, int length) {
        if (length <= 0) {
            return 0;
        }
        return arraySum(array, length - 1) + array[length - 1];
    }

    public String reverse(String input) {
        if (input.isEmpty()) {
            return input;
        }
       return reverse(input.substring(1)) + input.charAt(0);
    }

    protected int counting(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        if (input.charAt(0) == 'x') {
            return counting(input.substring(1)) + 1;
        }
        return counting(input.substring(1));
    }


}
