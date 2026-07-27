package javakb.ch06_strings;

/**
 * StringBuilderAndBuffer demonstrates mutable string classes in Java:
 * 1. Why String concatenation (+) in loops causes severe performance degradation.
 * 2. StringBuilder vs StringBuffer (unsynchronized vs synchronized).
 * 3. Capacity management vs Length.
 * 4. In-place manipulation operations: append, insert, delete, reverse, replace, setCharAt.
 * 5. Execution timing benchmark comparison.
 */
public class StringBuilderAndBuffer {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" 1. MUTABLE vs IMMUTABLE MECHANICS");
        System.out.println("==================================================");

        // String modification creates new objects
        String str = "Hello";
        System.out.println("Original String Hash: " + System.identityHashCode(str));
        str += " World";
        System.out.println("Modified String Hash: " + System.identityHashCode(str) + " (NEW Object Created!)");

        // StringBuilder modification modifies the SAME internal array
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Original StringBuilder Hash: " + System.identityHashCode(sb));
        sb.append(" World");
        System.out.println("Modified StringBuilder Hash: " + System.identityHashCode(sb) + " (SAME Object Modified!)");

        System.out.println("\n==================================================");
        System.out.println(" 2. CAPACITY vs LENGTH");
        System.out.println("==================================================");

        StringBuilder sbCap = new StringBuilder(); // Default capacity = 16
        System.out.println("Default initial capacity: " + sbCap.capacity());
        System.out.println("Initial length: " + sbCap.length());

        sbCap.append("1234567890123456"); // 16 characters
        System.out.println("Capacity at 16 chars: " + sbCap.capacity());
        System.out.println("Length at 16 chars: " + sbCap.length());

        sbCap.append("7"); // 17th char triggers automatic capacity growth (oldCapacity * 2 + 2)
        System.out.println("Capacity after 17th char: " + sbCap.capacity() + " (Auto-expanded!)");
        System.out.println("Length after 17th char: " + sbCap.length());

        System.out.println("\n==================================================");
        System.out.println(" 3. CORE STRINGBUILDER OPERATIONS");
        System.out.println("==================================================");

        StringBuilder builder = new StringBuilder("Java Programming");
        System.out.println("Initial: " + builder);

        // append()
        builder.append(" 2026");
        System.out.println("after append(\" 2026\"): " + builder);

        // insert()
        builder.insert(4, " SE");
        System.out.println("after insert(4, \" SE\"): " + builder);

        // setCharAt()
        builder.setCharAt(0, 'j');
        System.out.println("after setCharAt(0, 'j'): " + builder);

        // replace()
        builder.replace(0, 4, "JAVA");
        System.out.println("after replace(0, 4, \"JAVA\"): " + builder);

        // deleteCharAt() & delete()
        builder.deleteCharAt(4); // removes space
        System.out.println("after deleteCharAt(4): " + builder);
        builder.delete(15, builder.length()); // removes trailing year
        System.out.println("after delete(15, end): " + builder);

        // reverse()
        builder.reverse();
        System.out.println("after reverse(): " + builder);
        builder.reverse(); // reverse back
        System.out.println("after reverse() back: " + builder);

        System.out.println("\n==================================================");
        System.out.println(" 4. STRINGBUILDER vs STRINGBUFFER");
        System.out.println("==================================================");
        System.out.println("StringBuilder: Unsynchronized (Fast, Single-threaded)");
        System.out.println("StringBuffer:  Synchronized   (Thread-safe, Overhead)");

        StringBuffer sBuffer = new StringBuffer("Thread-Safe Buffer");
        sBuffer.append(" Demonstration");
        System.out.println("StringBuffer output: " + sBuffer);

        System.out.println("\n==================================================");
        System.out.println(" 5. PERFORMANCE BENCHMARK: STRING vs STRINGBUILDER");
        System.out.println("==================================================");

        int iterations = 50000;
        System.out.println("Performing " + iterations + " concatenation operations...\n");

        // Benchmark 1: Immutable String (+)
        long startTime = System.currentTimeMillis();
        String testStr = "";
        for (int i = 0; i < iterations; i++) {
            testStr += "a";
        }
        long endTime = System.currentTimeMillis();
        long stringDuration = endTime - startTime;
        System.out.println("1. String Concatenation (+) Time: " + stringDuration + " ms");

        // Benchmark 2: Mutable StringBuilder
        startTime = System.currentTimeMillis();
        StringBuilder testSb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            testSb.append("a");
        }
        endTime = System.currentTimeMillis();
        long sbDuration = endTime - startTime;
        System.out.println("2. StringBuilder append() Time: " + sbDuration + " ms");

        System.out.println("\nConclusion: StringBuilder is ~" 
            + (stringDuration > 0 && sbDuration > 0 ? (stringDuration / Math.max(1, sbDuration)) : "100+") 
            + "x faster for repetitive loop modifications!");
    }
}
