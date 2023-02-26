package com.jlr.assignment;

import java.util.Map;

/**
 * Class to translate Base 10 numbers to Roman Numbers
 */
public class RomanNumberTranslator {

    /**
     * Catalog to initialize mapping values of Base10 to Roman numbers
     */
    private static final Map<Integer, Map<Integer, String>> catalog = Map.of(
            0, Map.of( 0, "", 1, "I", 2, "II", 3, "III", 4, "IV", 5, "V", 6, "VI", 7, "VII", 8, "VIII", 9, "IX"),
            1, Map.of( 0, "", 1, "X", 2, "XX", 3, "XXX", 4, "XL", 5, "L", 6, "LX", 7, "LXX", 8, "LXXX", 9, "XC"),
            2, Map.of( 0, "", 1, "C", 2, "CC", 3, "CCC", 4, "CD", 5, "D", 6, "DC", 7, "DCC", 8, "DCCC", 9, "CM"),
            3, Map.of( 0, "", 1, "M", 2, "MM", 3, "MMM"));;

    /**
     * Main method to translate Base10 to Roman number
     */
    public String translate(final int baseTenNumber) throws IllegalArgumentException {

        if ( baseTenNumber < 1 || baseTenNumber > 3999) {
            throw new IllegalArgumentException("Number should be in between 0 and 4000");
        } else {
            return translateBase10(0, baseTenNumber);
        }
    }

    /**
     * Recursive way to find the Roman Numbers equalent to base10 numbers.
     * @param base
     * @param number
     * @return
     */
    private String translateBase10(final int base, final int number) {
        StringBuilder sb = new StringBuilder();
        if (number != 0 ){
            sb.append(translateBase10((base + 1), number/ 10));
            sb.append(catalog.get(base).get(number % 10));
        }
        return sb.toString();
    }

}
