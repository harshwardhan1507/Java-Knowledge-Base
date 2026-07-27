package javakb.ch01_basics;

/**
 * MathClassDemo demonstrates java.lang.Math utility functions.
 * 
 * Featured Methods:
 * - Math.max(a, b): Returns the maximum of two numbers
 * - Math.min(a, b): Returns the minimum of two numbers
 * - Math.abs(a): Returns the absolute value
 * - Math.sqrt(a): Returns the square root as double
 * - Math.pow(a, b): Returns a raised to the power of b as double
 * - Math.round(a): Rounds double/float to nearest long/int
 * - Math.ceil(a): Rounds up to the nearest whole double
 * - Math.floor(a): Rounds down to the nearest whole double
 * - Math.random(): Returns a random double in range [0.0, 1.0)
 */
public class MathClassDemo {
    public static void main(String[] args) {
        int max = Math.max(4, 78);
        System.out.println("Max of (4, 78): " + max);

        int min = Math.min(4, 78);
        System.out.println("Min of (4, 78): " + min);

        int abs = Math.abs(-23);
        System.out.println("Absolute of (-23): " + abs);

        double sqrt = Math.sqrt(16.0); // Returns 4.0
        System.out.println("Square root of (16.0): " + sqrt);

        double power = Math.pow(2, 3); // Returns 8.0
        System.out.println("2 to the power of 3: " + power);

        long round = Math.round(3.14); // Returns 3
        System.out.println("Math.round(3.14): " + round);

        double ceil = Math.ceil(3.14); // Returns 4.0
        System.out.println("Math.ceil(3.14): " + ceil);

        double floor = Math.floor(4.78); // Returns 4.0
        System.out.println("Math.floor(4.78): " + floor);

        double random = Math.random(); // Returns double between 0.0 and 1.0
        System.out.println("Math.random(): " + random);
    }
}