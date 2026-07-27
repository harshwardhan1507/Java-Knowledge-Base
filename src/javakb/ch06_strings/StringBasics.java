package javakb.ch06_strings;

/**
 * StringBasics demonstrates core string concepts in Java:
 * 1. String declaration & memory allocation (Literal vs new String()).
 * 2. String Constant Pool (SCP) vs Heap.
 * 3. String Immutability.
 * 4. Reference comparison (==) vs Content comparison (.equals()).
 * 5. String Interning via intern().
 */
public class StringBasics {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" 1. STRING CREATION: LITERAL vs NEW KEYWORD");
        System.out.println("==================================================");

        // String Literal: Stored in String Constant Pool (SCP)
        String s1 = "Java";
        String s2 = "Java"; // Reuses reference from SCP

        // 'new' keyword: Explicitly creates a new object on Heap
        String s3 = new String("Java");
        String s4 = new String("Java");

        System.out.println("s1 (Literal): " + s1);
        System.out.println("s2 (Literal): " + s2);
        System.out.println("s3 (new String): " + s3);
        System.out.println("s4 (new String): " + s4);

        System.out.println("\n==================================================");
        System.out.println(" 2. REFERENCE COMPARISON (==) vs VALUE (.equals())");
        System.out.println("==================================================");

        // == checks if both references point to the EXACT SAME memory location
        System.out.println("s1 == s2 (Both literals in SCP): " + (s1 == s2));         // true
        System.out.println("s1 == s3 (SCP vs Heap): " + (s1 == s3));                  // false
        System.out.println("s3 == s4 (Two separate Heap objects): " + (s3 == s4));     // false

        // .equals() checks character-by-character content equality
        System.out.println("s1.equals(s2): " + s1.equals(s2));                        // true
        System.out.println("s1.equals(s3): " + s1.equals(s3));                        // true
        System.out.println("s3.equals(s4): " + s3.equals(s4));                        // true

        System.out.println("\n==================================================");
        System.out.println(" 3. MEMORY IDENTITY HASH CODES");
        System.out.println("==================================================");

        System.out.println("s1 Identity Hash: " + System.identityHashCode(s1));
        System.out.println("s2 Identity Hash: " + System.identityHashCode(s2)); // Same as s1
        System.out.println("s3 Identity Hash: " + System.identityHashCode(s3)); // Unique Heap address
        System.out.println("s4 Identity Hash: " + System.identityHashCode(s4)); // Unique Heap address

        System.out.println("\n==================================================");
        System.out.println(" 4. STRING IMMUTABILITY DEMONSTRATION");
        System.out.println("==================================================");

        String original = "Hello";
        System.out.println("Original String before concat: " + original);
        System.out.println("Original Identity Hash: " + System.identityHashCode(original));

        // concat() returns a NEW string object; original remains unchanged
        String modified = original.concat(" World");
        System.out.println("Original String after concat: " + original); // Still "Hello"
        System.out.println("Modified String result: " + modified);        // "Hello World"
        System.out.println("Modified Identity Hash: " + System.identityHashCode(modified));

        System.out.println("\n==================================================");
        System.out.println(" 5. STRING INTERNING (intern())");
        System.out.println("==================================================");

        // intern() returns canonical reference from String Constant Pool
        String internedS3 = s3.intern();
        System.out.println("s1 == s3.intern(): " + (s1 == internedS3)); // true
        System.out.println("s1 Identity Hash: " + System.identityHashCode(s1));
        System.out.println("s3.intern() Identity Hash: " + System.identityHashCode(internedS3));
    }
}
