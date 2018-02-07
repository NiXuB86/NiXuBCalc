package com.github.nixub86.nixubcalc;

/**
 * Created by nixub on 06.02.2018.
 */

public class NXBMathUtils {

    public static Integer factorial(Integer n)
    {
        if (n == 0) return 1;
        return n * factorial(n-1);
    }
    public static String niceDoubleOutput(Double d) {
        if (d % 1.0 != 0)
            return String.format("%s", d);
        else
            return String.format("%.0f",d);
    }

    public static double log2(double num)
    {
        return (logb(num, 2));
    }

    public static double logb(double num, double NS)
    {
        return (Math.log(num)/Math.log(NS));
    }
}
