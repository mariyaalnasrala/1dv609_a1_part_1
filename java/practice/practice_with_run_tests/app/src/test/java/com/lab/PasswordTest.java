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
        return (IPassword) new BugWrongExceptionMessage(s);
        // return (IPassword) new BugMissingPasswordLengthCheck(s);
        // return (IPassword) new BugMissingNumberCheck(s);
        // return (IPassword) new BugIsPasswordSameAlwaysTrue(s);
        // return (IPassword) new BugWrongHashingAlgorithm(s);
    }

    private final String correctPassword = "CorrectVersion123!";
    private final String[] incorrectPass = {"", "fgh76", "abcddf23456"};

    @Test
    public void shouldAlwaysPass() throws Exception {
        assertTrue(true);
    }

    // test the length of passwords
    @Test
    public void constructorShouldThrowExceptionForShortPasswords() {
        for (String pw : incorrectPass) {
            Exception ex = assertThrows(Exception.class, () -> getPassword(pw));
            assertEquals("To short password", ex.getMessage());
        }

    }

    // test passwords without numbers
    @Test
    public void constructorShouldThrowExceptionForPasswordWithoutNumber() {
        assertThrows(Exception.class, () -> getPassword("PasswordWithoutNum"));
    }


    // test if the password trimmed
    @Test
    public void isPasswordSameShouldReturnTrueForTrimmedPasswords() throws Exception {
        IPassword p1 = getPassword("   ValidPassword123   ");
        IPassword p2 = getPassword("ValidPassword123");
        assertTrue(p1.isPasswordSame(p2));
    }


    // return false for different passwords
    @Test
    public void isPasswordSameShouldReturnFalseForDifferentPasswords() throws Exception {
        IPassword p1 = getPassword("ValidPassword123!");
        IPassword p2 = getPassword("DifferentPassword123!");
        assertFalse(p1.isPasswordSame(p2));
    }

    // test if hash are same for same passwords
    @Test
    public void passwordHashShouldBeSameForSamePasswords() throws Exception {
        IPassword pw = getPassword(correctPassword);
        int hashValue = 7;
        for (int i = 0; i < correctPassword.length(); i++) {
            hashValue = hashValue * 31 + correctPassword.charAt(i);
        }
        assertEquals(hashValue, pw.getPasswordHash());
    }
}
