package javakb.ch06_strings;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * StringAlgorithms provides clean, production-grade reference implementations
 * for popular coding interview string problems.
 * 
 * Included Algorithms:
 * 1. String Reversal (Two-pointer & StringBuilder)
 * 2. Palindrome Verification (Case & Space insensitive)
 * 3. Vowel & Consonant Counting
 * 4. Word Counting
 * 5. Character Frequency Analysis
 * 6. Duplicate Character Removal (Order-preserving)
 * 7. Anagram Validation (Character array sorting / frequency map)
 * 8. Case Toggling
 */
public class StringAlgorithms {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" 1. STRING REVERSAL");
        System.out.println("==================================================");
        String sample = "JavaProgramming";
        System.out.println("Original: " + sample);
        System.out.println("Reversed (Two Pointer): " + reverseString(sample));

        System.out.println("\n==================================================");
        System.out.println(" 2. PALINDROME CHECK");
        System.out.println("==================================================");
        String pal1 = "A man, a plan, a canal: Panama";
        String pal2 = "Hello World";
        System.out.println("\"" + pal1 + "\" is Palindrome? " + isPalindrome(pal1));
        System.out.println("\"" + pal2 + "\" is Palindrome? " + isPalindrome(pal2));

        System.out.println("\n==================================================");
        System.out.println(" 3. VOWEL & CONSONANT COUNTING");
        System.out.println("==================================================");
        countVowelsAndConsonants("Knowledge Base 2026");

        System.out.println("\n==================================================");
        System.out.println(" 4. WORD COUNTING");
        System.out.println("==================================================");
        String text = "   Java   is an   awesome programming  language!   ";
        System.out.println("Text: \"" + text + "\"");
        System.out.println("Word Count: " + countWords(text));

        System.out.println("\n==================================================");
        System.out.println(" 5. CHARACTER FREQUENCY ANALYSIS");
        System.out.println("==================================================");
        printCharacterFrequency("abracadabra");

        System.out.println("\n==================================================");
        System.out.println(" 6. REMOVE DUPLICATES");
        System.out.println("==================================================");
        String dupes = "programming";
        System.out.println("Original: " + dupes);
        System.out.println("Deduplicated: " + removeDuplicates(dupes));

        System.out.println("\n==================================================");
        System.out.println(" 7. ANAGRAM VALIDATION");
        System.out.println("==================================================");
        String w1 = "listen";
        String w2 = "silent";
        String w3 = "hello";
        System.out.println("Is \"" + w1 + "\" & \"" + w2 + "\" Anagram? " + isAnagram(w1, w2));
        System.out.println("Is \"" + w1 + "\" & \"" + w3 + "\" Anagram? " + isAnagram(w1, w3));

        System.out.println("\n==================================================");
        System.out.println(" 8. TOGGLE CASE");
        System.out.println("==================================================");
        String mixed = "Java 21 Code Base!";
        System.out.println("Original: " + mixed);
        System.out.println("Toggled:  " + toggleCase(mixed));
    }

    /**
     * 1. Reverses a string using Two-Pointer char array swapping.
     * Time Complexity: O(N), Space Complexity: O(N)
     */
    public static String reverseString(String input) {
        if (input == null) return null;
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    /**
     * 2. Checks if a string is a valid palindrome (ignoring non-alphanumeric & case).
     * Time Complexity: O(N), Space Complexity: O(1)
     */
    public static boolean isPalindrome(String input) {
        if (input == null) return false;
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(input.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(input.charAt(right))) right--;
            
            char cLeft = Character.toLowerCase(input.charAt(left));
            char cRight = Character.toLowerCase(input.charAt(right));
            
            if (cLeft != cRight) return false;
            left++;
            right--;
        }
        return true;
    }

    /**
     * 3. Counts total vowels and consonants in a string.
     */
    public static void countVowelsAndConsonants(String input) {
        if (input == null) return;
        int vowels = 0;
        int consonants = 0;
        String str = input.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Input: \"" + input + "\"");
        System.out.println("Vowels Count: " + vowels);
        System.out.println("Consonants Count: " + consonants);
    }

    /**
     * 4. Counts words handling spaces and empty inputs.
     */
    public static int countWords(String input) {
        if (input == null || input.isBlank()) return 0;
        String[] words = input.trim().split("\\s+");
        return words.length;
    }

    /**
     * 5. Frequency of each character maintaining insertion order.
     */
    public static void printCharacterFrequency(String input) {
        if (input == null) return;
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (char ch : input.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        System.out.println("Character frequency for \"" + input + "\": " + freqMap);
    }

    /**
     * 6. Removes duplicate characters while keeping original order.
     */
    public static String removeDuplicates(String input) {
        if (input == null) return null;
        StringBuilder sb = new StringBuilder();
        boolean[] seen = new boolean[256]; // ASCII set
        for (char ch : input.toCharArray()) {
            if (ch < 256) {
                if (!seen[ch]) {
                    seen[ch] = true;
                    sb.append(ch);
                }
            } else {
                if (sb.indexOf(String.valueOf(ch)) == -1) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 7. Checks if two strings are anagrams (same characters with same frequencies).
     */
    public static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        String str1 = s1.replaceAll("\\s+", "").toLowerCase();
        String str2 = s2.replaceAll("\\s+", "").toLowerCase();
        if (str1.length() != str2.length()) return false;

        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    /**
     * 8. Toggles uppercase characters to lowercase and vice versa.
     */
    public static String toggleCase(String input) {
        if (input == null) return null;
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (Character.isUpperCase(ch)) {
                chars[i] = Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                chars[i] = Character.toUpperCase(ch);
            }
        }
        return new String(chars);
    }
}
