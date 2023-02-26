package com.jlr.assignment;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RomanNumberTranslatorTest {

    private RomanNumberTranslator translator = new RomanNumberTranslator();

    @Test
    void translateNumberShouldBeInBetween0and4000() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            translator.translate(4000);
        }).withMessage("Number should be in between 0 and 4000");
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            translator.translate(0);
        }).withMessage("Number should be in between 0 and 4000");
    }

    @Test
    void translateValidNumbers() {
        validate( 1, "I");
        validate( 2, "II");
        validate( 3, "III");
        validate( 4, "IV");
        validate( 5, "V");
        validate( 6, "VI");
        validate( 7, "VII");
        validate( 8, "VIII");
        validate( 9, "IX");
        validate( 10, "X");
        validate( 11, "XI");
        validate( 21, "XXI");
        validate( 55, "LV");
        validate( 111, "CXI");
        validate( 666, "DCLXVI");
        validate( 1994, "MCMXCIV");
        validate( 3999, "MMMCMXCIX");
    }

    private void validate(final int actual, final String expected) {
        assertThat(translator.translate(actual)).isEqualTo(expected);

    }
}