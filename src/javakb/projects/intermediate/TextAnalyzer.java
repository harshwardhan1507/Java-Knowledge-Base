package javakb.projects.intermediate;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * TextAnalyzer — Intermediate String & Text Analysis Mini-Project
 *
 * Features:
 * - Character count (Total, Letters, Digits, Spaces, Special Characters)
 * - Word count & Average word length
 * - Vowel & Consonant statistics
 * - Text reversal
 * - Palindrome verification
 * - Character frequency distribution
 * - Search & Word Replacement
 */
public class TextAnalyzer {

    // Helper: Reverse a string using StringBuilder
    public static String reverseString(String text) {
        if (text == null) return "";
        return new StringBuilder(text).reverse().toString();
    }

    // Helper: Palindrome verification (ignoring case & non-alphanumeric chars)
    public static boolean isPalindrome(String text) {
        if (text == null || text.isEmpty()) return true;
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // Helper: Count words
    public static int countWords(String text) {
        if (text == null || text.isBlank()) return 0;
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    // Helper: Analyze vowels & consonants
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        String lower = text.toLowerCase();
        for (char ch : lower.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels Count:     " + vowels);
        System.out.println("Consonants Count: " + consonants);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";

        System.out.println("==================================================");
        System.out.println("     Welcome to JavaKB Console Text Analyzer      ");
        System.out.println("==================================================");

        System.out.print("\nEnter initial text to analyze: ");
        text = scanner.nextLine();

        boolean running = true;
        while (running) {
            System.out.println("\n--------------------------------------------------");
            System.out.println(" Current Text: \"" + (text.length() > 50 ? text.substring(0, 47) + "..." : text) + "\"");
            System.out.println("--------------------------------------------------");
            System.out.println("1. Count Characters (Total, Letters, Digits, Spaces)");
            System.out.println("2. Count Words & Average Word Length");
            System.out.println("3. Count Vowels & Consonants");
            System.out.println("4. Reverse Text");
            System.out.println("5. Check Palindrome");
            System.out.println("6. Character Frequency Breakdown");
            System.out.println("7. Find & Replace Word");
            System.out.println("8. Enter New Text");
            System.out.println("9. Exit");
            System.out.print("Select an option (1-9): ");

            String choiceInput = scanner.nextLine().strip();
            int choice = -1;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 9.");
                continue;
            }

            switch (choice) {
                case 1 -> analyzeCharacters(text);
                case 2 -> analyzeWords(text);
                case 3 -> analyzeVowels(text);
                case 4 -> System.out.println("\nReversed Text: \"" + reverseString(text) + "\"");
                case 5 -> {
                    boolean isPal = isPalindrome(text);
                    System.out.println("\nPalindrome Check: " + (isPal ? "YES! It is a valid palindrome." : "NO. It is not a palindrome."));
                }
                case 6 -> showFrequency(text);
                case 7 -> text = replaceWord(scanner, text);
                case 8 -> {
                    System.out.print("\nEnter new text: ");
                    text = scanner.nextLine();
                }
                case 9 -> {
                    running = false;
                    System.out.println("\nThank you for using JavaKB Text Analyzer. Goodbye!");
                }
                default -> System.out.println("Invalid option! Choice must be between 1 and 9.");
            }
        }
        scanner.close();
    }

    private static void analyzeCharacters(String text) {
        int total = text.length();
        int letters = 0;
        int digits = 0;
        int spaces = 0;
        int special = 0;

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) letters++;
            else if (Character.isDigit(ch)) digits++;
            else if (Character.isWhitespace(ch)) spaces++;
            else special++;
        }

        System.out.println("\n--- Character Breakdown ---");
        System.out.println("Total Length:       " + total);
        System.out.println("Letters (a-z, A-Z): " + letters);
        System.out.println("Digits (0-9):       " + digits);
        System.out.println("Whitespaces:        " + spaces);
        System.out.println("Special Symbols:    " + special);
    }

    private static void analyzeWords(String text) {
        int wordCount = countWords(text);
        if (wordCount == 0) {
            System.out.println("\nText contains 0 words.");
            return;
        }

        String[] words = text.trim().split("\\s+");
        int totalLettersInWords = 0;
        for (String word : words) {
            totalLettersInWords += word.length();
        }
        double avgLength = (double) totalLettersInWords / wordCount;

        System.out.println("\n--- Word Breakdown ---");
        System.out.println("Total Words: " + wordCount);
        System.out.printf("Average Word Length: %.2f characters%n", avgLength);
    }

    private static void analyzeVowels(String text) {
        System.out.println("\n--- Vowel & Consonant Statistics ---");
        countVowelsAndConsonants(text);
    }

    private static void showFrequency(String text) {
        if (text.isEmpty()) {
            System.out.println("\nText is empty.");
            return;
        }
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (char ch : text.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        System.out.println("\n--- Character Frequency Distribution ---");
        freqMap.forEach((ch, count) -> {
            String label = (ch == ' ') ? "<SPACE>" : (ch == '\t') ? "<TAB>" : String.valueOf(ch);
            System.out.printf("'%s' : %d%n", label, count);
        });
    }

    private static String replaceWord(Scanner scanner, String text) {
        System.out.print("\nEnter target word/character to find: ");
        String target = scanner.nextLine();
        if (target.isEmpty()) {
            System.out.println("Target cannot be empty.");
            return text;
        }

        if (!text.contains(target)) {
            System.out.println("Target \"" + target + "\" not found in text.");
            return text;
        }

        System.out.print("Enter replacement word/character: ");
        String replacement = scanner.nextLine();

        String updated = text.replace(target, replacement);
        System.out.println("Replacement successful!");
        System.out.println("New Text: \"" + updated + "\"");
        return updated;
    }
}
