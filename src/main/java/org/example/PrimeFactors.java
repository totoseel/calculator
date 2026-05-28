package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    public List<Integer> calculate(int number){
        List<Integer> factors = new ArrayList<>();
        if (number < 2) {
            return factors;
        }

        for (int i = 2; i * i <= number; i++) {
            while (number % i == 0) {
                factors.add(i);
                number /= i;
            }
        }

        if (number > 1) {
            factors.add(number);
        }

        return factors;
    }
}
