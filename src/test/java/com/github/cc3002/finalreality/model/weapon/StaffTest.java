package com.github.cc3002.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StaffTest extends AbstractWeaponTest{

    @BeforeEach
    void setUp() {
        testStaff = new Staff(STAFF_NAME, DAMAGE, SPEED);
    }

    @Test
    void constructorTest() {
        var expectedStaff = new Staff(STAFF_NAME, DAMAGE, SPEED);
        var diferentStaff1 = new Staff("Test", DAMAGE, SPEED);
        var diferentStaff2 = new Staff(STAFF_NAME, 1, SPEED);
        var diferentStaff3 = new Staff(STAFF_NAME, DAMAGE, 1);
        var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
        assertEquals(expectedStaff, testStaff);
        assertEquals(expectedStaff.hashCode(), testStaff.hashCode());

        assertTrue(expectedStaff.equals(expectedStaff));
        assertFalse(expectedStaff.equals(diferentStaff1));
        assertFalse(expectedStaff.equals(diferentStaff2));
        assertFalse(expectedStaff.equals(diferentStaff3));
        assertFalse(expectedStaff.equals(expectedAxe));
    }
}
