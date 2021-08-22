package recursion;

public class MainRecursion {

    public static long factorial(int num) {
        if (num >= 1)
            return num * factorial(num - 1);
        else
            return 1;
    }

    public static long factorialWithOutRecursion(int num) {
        int i;
        int fact = 1;
        for(i = 1; i <= num; i++){
            fact = fact * i;
        }
        return fact;
    }


    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(factorialWithOutRecursion(3));
    }

}
