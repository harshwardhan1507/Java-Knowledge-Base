package javakb.ch06_strings;

import java.util.Arrays;

/**
 * StringMethods demonstrates essential java.lang.String methods grouped by purpose.
 * 
 * Revision Categories:
 * 1. Length & Access
 * 2. Search & Inspection
 * 3. Comparison & Ordering
 * 4. Extraction & Substrings
 * 5. Case Conversion
 * 6. Replacement
 * 7. Trimming, Stripping & Blank Checks
 * 8. Splitting & Joining
 * 9. Type Conversions
 * 10. Method Chaining (Fluent operations)
 */
public class StringMethods {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" 1. LENGTH & CHARACTER ACCESS");
        System.out.println("==================================================");
        String str = "Java Programming";
        System.out.println("Text: \"" + str + "\"");
        System.out.println("length(): " + str.length());
        System.out.println("charAt(0): " + str.charAt(0));
        System.out.println("charAt(5): " + str.charAt(5));
        
        char[] charArr = str.toCharArray();
        System.out.println("toCharArray(): " + Arrays.toString(charArr));

        System.out.println("\n==================================================");
        System.out.println(" 2. SEARCH & INSPECTION");
        System.out.println("==================================================");
        String phrase = "The quick brown fox jumps over the lazy dog";
        System.out.println("Phrase: \"" + phrase + "\"");
        System.out.println("indexOf(\"brown\"): " + phrase.indexOf("brown"));
        System.out.println("indexOf('o'): " + phrase.indexOf('o'));             // First occurrence
        System.out.println("lastIndexOf('o'): " + phrase.lastIndexOf('o'));     // Last occurrence
        System.out.println("contains(\"fox\"): " + phrase.contains("fox"));
        System.out.println("contains(\"cat\"): " + phrase.contains("cat"));
        System.out.println("startsWith(\"The\"): " + phrase.startsWith("The"));
        System.out.println("endsWith(\"dog\"): " + phrase.endsWith("dog"));

        System.out.println("\n==================================================");
        System.out.println(" 3. COMPARISON & ORDERING");
        System.out.println("==================================================");
        String a = "Apple";
        String b = "apple";
        String c = "Banana";

        System.out.println("a: " + a + ", b: " + b + ", c: " + c);
        System.out.println("a.equals(b): " + a.equals(b));
        System.out.println("a.equalsIgnoreCase(b): " + a.equalsIgnoreCase(b));
        
        // compareTo returns: negative if a < c, 0 if equal, positive if a > c
        System.out.println("a.compareTo(c) ['Apple' vs 'Banana']: " + a.compareTo(c));
        System.out.println("c.compareTo(a) ['Banana' vs 'Apple']: " + c.compareTo(a));
        System.out.println("a.compareToIgnoreCase(b): " + a.compareToIgnoreCase(b));

        System.out.println("\n==================================================");
        System.out.println(" 4. EXTRACTION & SUBSTRINGS");
        System.out.println("==================================================");
        String message = "KnowledgeIsPower";
        System.out.println("Full Message: " + message);
        System.out.println("substring(0, 9): " + message.substring(0, 9));  // "Knowledge" (index 0 to 8)
        System.out.println("substring(9): " + message.substring(9));        // "IsPower" (index 9 to end)

        System.out.println("\n==================================================");
        System.out.println(" 5. CASE CONVERSION");
        System.out.println("==================================================");
        String mix = "Java 21 Knowledge Base";
        System.out.println("Original: " + mix);
        System.out.println("toLowerCase(): " + mix.toLowerCase());
        System.out.println("toUpperCase(): " + mix.toUpperCase());

        System.out.println("\n==================================================");
        System.out.println(" 6. REPLACEMENT");
        System.out.println("==================================================");
        String original = "cat, bat, rat, mat";
        System.out.println("Original: " + original);
        System.out.println("replace('a', 'o'): " + original.replace('a', 'o'));
        System.out.println("replace(\"cat\", \"dog\"): " + original.replace("cat", "dog"));
        System.out.println("replaceFirst(\"[a-z]at\", \"pet\"): " + original.replaceFirst("[a-z]at", "pet"));
        System.out.println("replaceAll(\"[a-z]at\", \"pet\"): " + original.replaceAll("[a-z]at", "pet"));

        System.out.println("\n==================================================");
        System.out.println(" 7. TRIMMING, STRIPPING & BLANK CHECKS");
        System.out.println("==================================================");
        String padded = "   Hello Java Developers!   \n";
        System.out.println("Padded: \"" + padded + "\"");
        System.out.println("trim(): \"" + padded.trim() + "\"");
        System.out.println("strip(): \"" + padded.strip() + "\"");             // Unicode-aware strip
        System.out.println("stripLeading(): \"" + padded.stripLeading() + "\"");
        System.out.println("stripTrailing(): \"" + padded.stripTrailing() + "\"");

        String emptyStr = "";
        String blankStr = "   \t \n";
        System.out.println("emptyStr.isEmpty(): " + emptyStr.isEmpty());  // length == 0
        System.out.println("blankStr.isEmpty(): " + blankStr.isEmpty());  // false (has spaces)
        System.out.println("blankStr.isBlank(): " + blankStr.isBlank());  // true (only whitespaces)

        System.out.println("\n==================================================");
        System.out.println(" 8. SPLITTING & JOINING");
        System.out.println("==================================================");
        String csv = "Red,Green,Blue,Yellow";
        String[] colors = csv.split(",");
        System.out.println("csv.split(\",\"): " + Arrays.toString(colors));

        String joined = String.join(" | ", colors);
        System.out.println("String.join(\" | \", colors): " + joined);

        System.out.println("\n==================================================");
        System.out.println(" 9. TYPE CONVERSIONS");
        System.out.println("==================================================");
        int num = 42;
        double pi = 3.14159;
        boolean flag = true;

        String sNum = String.valueOf(num);
        String sPi = String.valueOf(pi);
        String sFlag = String.valueOf(flag);

        System.out.println("String.valueOf(int): " + sNum);
        System.out.println("String.valueOf(double): " + sPi);
        System.out.println("String.valueOf(boolean): " + sFlag);

        int parsedInt = Integer.parseInt("100");
        double parsedDouble = Double.parseDouble("99.99");
        System.out.println("Integer.parseInt(\"100\"): " + parsedInt);
        System.out.println("Double.parseDouble(\"99.99\"): " + parsedDouble);

        System.out.println("\n==================================================");
        System.out.println(" 10. METHOD CHAINING");
        System.out.println("==================================================");
        String rawInput = "   USER_INPUT_TEXT   ";
        String cleaned = rawInput.strip().toLowerCase().replace("_", " ");
        System.out.println("Raw Input: \"" + rawInput + "\"");
        System.out.println("Chained Result (.strip().toLowerCase().replace()): \"" + cleaned + "\"");
    }
}
