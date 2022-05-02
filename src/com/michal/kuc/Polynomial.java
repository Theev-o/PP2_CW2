package com.michal.kuc;

import java.util.Random;

public class Polynomial {
    Double[] coefficients;

    public Polynomial(int n) {
        coefficients = new Double[n + 1];
    }

    void randFill() {
        Random rnd = new Random();
        for (int i = 0; i < coefficients.length; i++) {
            coefficients[i] = (double) rnd.nextInt(9);
        }
    }

    void fill(Double... nums) {
        if (nums.length == coefficients.length) {
            System.arraycopy(nums, 0, coefficients, 0, nums.length);
        } else {
            System.out.println("Incorrect number of coefficients for polynomial of degree " + coefficients.length + ".");
        }
    }

    Double eval(Double x) {
        Double result = coefficients[coefficients.length - 1];
        for (int i = coefficients.length - 2; i >= 0; i--) {
            result = coefficients[i] + (x * result);
        }
        return result;
    }

    public Integer getDegree() {
        return coefficients.length - 1;
    }

    public String toString() {
        StringBuilder representation = new StringBuilder();
        for (int i = getDegree(); i >= 0; i--) {
            if (coefficients[i] != 0) {
                if (coefficients[i] > 0) {
                    representation.append(" ").append(coefficients[i]).append("x^").append(i).append(" +");
                } else {
                    representation.append(" (-").append(coefficients[i]).append("x^").append(i).append(") +");
                }
            }
        }
        return representation.substring(1, representation.length() - 1);
    }

}
