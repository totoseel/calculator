package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimeFactorsTest {
    PrimeFactors primeFactors = new PrimeFactors();
    @Test
    void testConstantCase() {
        Integer[] calculate_2 = primeFactors.calculate(2);
        Assertions.assertEquals(2, calculate_2[0]);

        Integer[] calculate_3 = primeFactors.calculate(3);
        Assertions.assertEquals(3, calculate_3[0]);

        Integer[] calculate_4 = primeFactors.calculate(4);
        Assertions.assertEquals(2, calculate_4[0]);
        Assertions.assertEquals(2, calculate_4[1]);
    }
}