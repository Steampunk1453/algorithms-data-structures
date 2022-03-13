package recursion;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainRecursion {

    protected void countDown(int num) {
        System.out.println(num);
        if (num == 0) {
            return;
        }
        countDown(num - 1);
    }

    protected int factorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    protected long factorial1(int num) {
        if (num >= 1)
            return num * factorial1(num - 1);
        else
            return 1;
    }

    protected long factorialWithOutRecursion(int num) {
        int i;
        int fact = 1;
        for (i = 1; i <= num; i++) {
            fact = fact * i;
        }
        return fact;
    }

    protected int[] arrayDouble(int[] array, int index) {
        if (index < array.length) {
            array[index] = array[index] * 2;
            arrayDouble(array, index + 1);
        }
        return array;
    }

    protected void arrayDouble1(int[] array, int index) {
        if (index >= array.length) {
            return;
        }
        array[index] = array[index] * 2;
        arrayDouble1(array, index + 1);
    }

    protected int arraySum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        } else {
            return arr[0] + arraySum(Arrays.copyOfRange(arr, 1, arr.length));
        }
    }

    protected int arraySum1(int[] array, int length) {
        if (length <= 0) {
            return 0;
        }
        return array[length - 1] + arraySum1(array, length - 1);
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
            return 1 + counting(input.substring(1));
        }
        return counting(input.substring(1));
    }

    protected int arrayCharacters(String[] arr) {
        if (arr.length == 1) {
            return arr[0].length();
        } else {
            return arr[0].length() + arrayCharacters(Arrays.copyOfRange(arr, 1, arr.length));
        }
    }

    protected List<Integer> evenNumbers(int[] array, List<Integer> results) {
         if (array[0] % 2 == 0) {
            results.add(array[0]);
        }
        if (array.length == 1) {
            return results;
        }
        evenNumbers(Arrays.copyOfRange(array, 1, array.length), results);
        return results;
    }

    protected int triangularNumber(int num) {
        if (num == 1) {
            return num;
        }
        return num + triangularNumber(num - 1 );
    }

    protected int getIndex(String input) {
        if (Objects.equals(input.substring(0, 1), "x")) {
            return 0;
        }
        return getIndex(input.substring(1)) + 1 ;
    }

    protected int getIndex1(char[] array, int index, char value) {
        if (array.length -1 == index) {
            if (array[index] == value) {
                return index;
            } else {
                return 0;
            }
        }
        else if (array[index]  == value) {
            return index;
        }
        return getIndex1(array, index + 1, value);
    }

    protected int uniquePaths(int rows, int columns) {
        if (rows == 1 || columns == 1) {
            return 1;
        }
        return uniquePaths(rows -1, columns) + uniquePaths(rows, columns -1);

    }

}