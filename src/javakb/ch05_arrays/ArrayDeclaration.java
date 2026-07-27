package javakb.ch05_arrays;

public class ArrayDeclaration {

    public static void main(String[] args) {
        // array declaration
        int[] numbers = new int[5];
        // array initialization
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        numbers[3] = 4;
        numbers[4] = 5;
        // array access
        System.out.println(numbers[0]);
        System.out.println(numbers[1]);
        System.out.println(numbers[2]);
        System.out.println(numbers[3]);
        System.out.println(numbers[4]);
        // there is no need to initialize all elements
        // if not initialized, the default value is 0
        int[] numbers2 = new int[5];
        System.out.println(numbers2[0]);
        System.out.println(numbers2[1]);
        System.out.println(numbers2[2]);
        System.out.println(numbers2[3]);
        System.out.println(numbers2[4]);

        // one more way to initialize
        int[] numbers3 = { 1, 2, 3, 4, 5 };
        System.out.println(numbers3[0]);
        System.out.println(numbers3[1]);
        System.out.println(numbers3[2]);
        System.out.println(numbers3[3]);
        System.out.println(numbers3[4]);

        // array looping
        for (int i = 0; i < numbers3.length; i++) {
            System.out.println(numbers3[i]);
        }

        for (int num : numbers3) {
            // advanced for loop
            System.out.println(num);
        }
    }
}
