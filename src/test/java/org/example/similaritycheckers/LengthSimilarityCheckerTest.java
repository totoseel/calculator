package org.example.similaritycheckers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LengthSimilarityCheckerTest {

    private LengthSimilarityChecker checker;

    @BeforeEach
    void setUp() {
        checker = new LengthSimilarityChecker();
    }

    @Test
    void sameLength_returns60() {
        assertThat(checker.calculate("ASD", "DSA")).isEqualTo(60);
    }

    @Test
    void doubleLengthDifference_returns0() {
        assertThat(checker.calculate("A", "BB")).isEqualTo(0);
    }
}
