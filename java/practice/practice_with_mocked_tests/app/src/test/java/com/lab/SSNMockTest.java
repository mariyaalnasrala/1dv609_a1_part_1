package com.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SSNMockTest {

    private SSNHelper mockHelper;

    private SwedishSocialSecurityNumber sut;

    private final String ssn = "950407-1234";
    private final String ssnWithSpaces = " 950407-1234 ";

    @BeforeEach
    void setUp() {
        mockHelper = mock(SSNHelper.class);

        // alla valideringar returnerar true
        when(mockHelper.isCorrectLength(anyString())).thenReturn(true);
        when(mockHelper.isCorrectFormat(anyString())).thenReturn(true);
        when(mockHelper.isValidMonth(anyString())).thenReturn(true);
        when(mockHelper.isValidDay(anyString())).thenReturn(true);
        when(mockHelper.luhnIsCorrect(anyString())).thenReturn(true);
    }

    @Test
    void constructorShouldThrowExceptionWhenLengthIsInvalid() {
        when(mockHelper.isCorrectLength(ssn)).thenReturn(false);

        assertThrows(IllegalArgumentException.class,
                () -> new SwedishSocialSecurityNumber(ssn, mockHelper));

        verify(mockHelper).isCorrectLength(ssn);
    }

    @Test
    void constructorShouldTrimString() throws Exception {
        sut = new SwedishSocialSecurityNumber(ssnWithSpaces, mockHelper);

        // Vi kan kontrollera att trim används genom att jämföra resultatet
        assertEquals("95", sut.getYear());
    }

    @Test
    void constructorShouldThrowExceptionWhenLuhnIsInvalid() {
        when(mockHelper.luhnIsCorrect(ssn)).thenReturn(false);

        assertThrows(IllegalArgumentException.class,
                () -> new SwedishSocialSecurityNumber(ssn, mockHelper));

        verify(mockHelper).luhnIsCorrect(ssn);
    }

    @Test
    void getYearShouldReturnFirstTwoDigits() throws Exception {
        sut = new SwedishSocialSecurityNumber(ssn, mockHelper);
        assertEquals("95", sut.getYear());
    }

    @Test
    void constructorShouldThrowExceptionWhenFormatIsInvalid() {
        when(mockHelper.isCorrectFormat(ssn)).thenReturn(false);

        assertThrows(IllegalArgumentException.class,
                () -> new SwedishSocialSecurityNumber(ssn, mockHelper));

        verify(mockHelper).isCorrectFormat(ssn);
    }

    @Test
    void constructorShouldThrowExceptionWhenMonthIsInvalid() {
        when(mockHelper.isValidMonth("04")).thenReturn(false);

        assertThrows(IllegalArgumentException.class,
                () -> new SwedishSocialSecurityNumber(ssn, mockHelper));

        verify(mockHelper).isValidMonth("04");
    }

    @Test
    void constructorShouldThrowExceptionWhenDayIsInvalid() {
        when(mockHelper.isValidDay("07")).thenReturn(false);

        assertThrows(IllegalArgumentException.class,
                () -> new SwedishSocialSecurityNumber(ssn, mockHelper));

        verify(mockHelper).isValidDay("07");
    }

    @Test
    void getSerialNumberShouldReturnLastFourDigits() throws Exception {
        sut = new SwedishSocialSecurityNumber(ssn, mockHelper);
        assertEquals("1234", sut.getSerialNumber());
    }

}
