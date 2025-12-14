package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SSNHelperTest {

    private  SSNHelper helper = new SSNHelper();

    
    @Test
    void correctLengthAccepted() {
        assertTrue(helper.isCorrectLength("890405-1234"));
    }

    @Test
    void tooShortLengthRejected() {
        assertFalse(helper.isCorrectLength("780512-123"));
    }

    @Test
    void correctFormatAccepted() {
        assertTrue(helper.isCorrectFormat("900909-1234"));
    }

    @Test
    void incorrectFormatRejected() {
        assertFalse(helper.isCorrectFormat("09-9834-1234"));
    }

    @Test
    void validMonthAccepted() {
        assertTrue(helper.isValidMonth("12"));
    }

    @Test
    void invalidMonthZeroRejected() {
        assertFalse(helper.isValidMonth("00"));
    }

    @Test
    void invalidMonthOverMaxRejected() {
        assertFalse(helper.isValidMonth("13"));
    }

    @Test
    void validDayAccepted() {
        assertTrue(helper.isValidDay("31"));
    }

    @Test
    void invalidDayZeroRejected() {
        assertFalse(helper.isValidDay("00"));
    }

    @Test
    void invalidDayOverMaxRejected() {
        assertFalse(helper.isValidDay("32"));
    }

    @Test
    void correctLuhnAccepted() {
        assertTrue(helper.luhnIsCorrect("900101-0017"));
    }

    @Test
    void incorrectLuhnRejected() {
        assertFalse(helper.luhnIsCorrect("900101-0018"));
    }

    /* Buggy versions */
    @Test
    void buggyWrongLengthShouldFail() {
        BuggySSNHelperWrongLength buggyHelper = new BuggySSNHelperWrongLength();
        assertFalse(buggyHelper.isCorrectLength("123456-123")); // 10 chars
    }

    @Test
    void buggyAllowMonthZeroShouldFail() {
        BuggySSNHelperAllowMonth0 buggyHelper = new BuggySSNHelperAllowMonth0();
        assertFalse(buggyHelper.isValidMonth("20"));
    }

    @Test
    void buggyAllowDayUpTo30ShouldFail() {
        BuggySSNHelperAllowDayUpTo30 buggyHelper = new BuggySSNHelperAllowDayUpTo30();
        assertFalse(buggyHelper.isValidDay("34"));
    }

    @Test
    void buggyLuhnShouldFail() {
        BuggySSNHelperMessyLuhn buggyHelper = new BuggySSNHelperMessyLuhn();
        assertFalse(buggyHelper.luhnIsCorrect("950407-1234"));
    }
}
