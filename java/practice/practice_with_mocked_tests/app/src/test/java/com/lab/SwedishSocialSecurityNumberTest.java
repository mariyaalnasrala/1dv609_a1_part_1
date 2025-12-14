package com.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SwedishSocialSecurityNumberTest {
    
    private SSNHelper helper;
    
    @BeforeEach
    public void setUp() {
        helper = new SSNHelper();
    }
    
    @Test
    public void shouldAcceptValidSSN() throws Exception {
        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber("900101-0017", helper);
        
        assertEquals("90", ssn.getYear());
        assertEquals("01", ssn.getMonth());
        assertEquals("01", ssn.getDay());
        assertEquals("0017", ssn.getSerialNumber());
    }
    
}