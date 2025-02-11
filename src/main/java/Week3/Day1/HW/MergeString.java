package Week3.Day1.HW;

import org.junit.Test;

public class MergeString {
    @Test
    public void testMergeAlternately1() {
        String result = mergeAlternately("abc", "pqr");
        System.out.println("Test 1 Result: " + result);
    }

    @Test
    public void testMergeAlternately2() {
        String result = mergeAlternately("ab", "pqrs");
        System.out.println("Test 2 Result: " + result);
    }

    @Test
    public void testMergeAlternately3() {
        String result = mergeAlternately("abcd", "pq");
        System.out.println("Test 3 Result: " + result);
    }

    public String mergeAlternately(String word1, String word2) {
        String merged = "";
        int minLength = Math.min(word1.length(), word2.length());

        // Merge the strings alternately using a for loop
        for (int i = 0; i < minLength; i++) {
            merged += word1.charAt(i);
            merged += word2.charAt(i);
        }

        // Append remaining characters from the longer string
        if (word1.length() > minLength) {
            merged += word1.substring(minLength);
        }

        if (word2.length() > minLength) {
            merged += word2.substring(minLength);
        }

        return merged;
    }
}

/*
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
starting with word1. If a string is longer than the other, append the additional letters onto the
end of the merged string. Return the merged string.

Example 1:
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

Example 2:
Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s

Example 3:
Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d
 */