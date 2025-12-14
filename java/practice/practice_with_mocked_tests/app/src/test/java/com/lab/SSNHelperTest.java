package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SSNHelperTest {

    private  SSNHelper helper = new SSNHelper();


    /*test the length */
    @Test
    void CorrectLength() {
        assertTrue(helper.isCorrectLength("890405-1234"));
    }

    @Test
    void TooShortLength() {
        assertFalse(helper.isCorrectLength("780512-123"));
    }

    /*Test  format*/
    @Test
    void CorrectFormat() {

        assertTrue(helper.isCorrectLength("900909-1234"));

    }

    @Test
    void IncorrectFormat() {
        assertFalse(helper.isCorrectFormat("09-9834-1234"));
    }

    /*Test months */
    @Test
    void ValidMonthAccepted() {
        assertTrue(helper.isValidMonth("12"));
    }

    @Test
    void InvalidMonth() {
        assertFalse(helper.isValidMonth("00"));
    }

    @Test
    void invalidMonthOverMax() {
        assertFalse(helper.isValidMonth("13"));
    }

    /*day tests*/
    @Test
    void validDayAccepted() {
        assertTrue(helper.isValidDay("31"));
    }

    @Test
    void invalidDayZero() {
        assertFalse(helper.isValidDay("00"));
    }

    @Test
    void DayOverMax() {
        assertFalse(helper.isValidDay("32"));
    }

    /*test Luhn */
    @Test
    void AcceptCorrectLuhnNumber() {
        assertTrue(helper.luhnIsCorrect("900101-0017"));
    }

    @Test
    void rejectIncorrectLuhnNumber() {
        assertFalse(helper.luhnIsCorrect("900101-0018"));
    }
}
