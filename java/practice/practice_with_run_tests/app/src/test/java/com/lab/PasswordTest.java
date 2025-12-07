package com.lab;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for Password implementations.
 *
 * To test different buggy versions, simply uncomment the corresponding
 * getPassword() method and comment out the others.
 *
 * Available implementations: - Password: Correct implementation -
 * BugDoesNotTrim: Does not trim whitespace - BugToShortPassword: Allows
 * passwords shorter than 12 characters - BugVeryShort: Allows way to short
 * passwords - BugWrongExceptionMessage: Wrong exception message for short
 * passwords - BugMissingPasswordLengthCheck: Does not throw exception for short
 * passwords - BugMissingNumberCheck: Does not throw exception if password lacks
 * a number - BugIsPasswordSameAlwaysTrue: isPasswordSame always returns true -
 * BugWrongHashingAlgorithm: Wrong hashing algorithm
 */
public class PasswordTest {

    private IPassword getPassword(String s) throws Exception {
        // return (IPassword) new Password(s);
        // return (IPassword) new BugDoesNotTrim(s);
        // return (IPassword) new BugToShortPassword(s);
        // return (IPassword) new BugToShortPassword(s);
        // return (IPassword) new BugVeryShort(s);
        // return (IPassword) new BugWrongExceptionMessage(s);
        // return (IPassword) new BugMissingPasswordLengthCheck(s);
        // return (IPassword) new BugMissingNumberCheck(s);
        // return (IPassword) new BugIsPasswordSameAlwaysTrue(s);
        return (IPassword) new BugWrongHashingAlgorithm(s);
    }

    @Test
    public void shouldAlwaysPass() throws Exception {
        assertTrue(true);
    }

    // test trimming 
    @Test
    public void testTrimming() throws Exception {
        IPassword WithSpace = getPassword("   ValidPassword123   ");
        IPassword WithoutSpace = getPassword("ValidPassword123");
        assertTrue(WithSpace.isPasswordSame(WithoutSpace), "Should be same after trimming");
    }

    // test too short password
    @Test
    public void TestTooShortPassword() throws Exception {
        assertThrows(Exception.class, () -> getPassword("abcrtu87123"),
                "Should throw exception for password shorter than 12 characters");

    }

    // password with numbers
    @Test
    public void testPasswordWithNumbers() {
        assertDoesNotThrow(() -> getPassword("Correctt123!"));
    }


}
