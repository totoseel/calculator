package org.example.similaritycheckers;

public class LengthSimilarityChecker {

    private static final int MAX_SCORE = 60;

    public int calculate(String a, String b) {
        int longer = Math.max(a.length(), b.length());
        int shorter = Math.min(a.length(), b.length());
        if (longer >= shorter * 2) {
            return 0;
        }
        return MAX_SCORE;
    }
}
